/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.input.validation.mgt.model.handlers;

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.identity.core.util.IdentityUtil;
import org.wso2.carbon.identity.input.validation.mgt.exceptions.InputValidationMgtClientException;
import org.wso2.carbon.identity.input.validation.mgt.exceptions.InputValidationMgtException;
import org.wso2.carbon.identity.input.validation.mgt.model.FieldValidationConfigurationHandler;
import org.wso2.carbon.identity.input.validation.mgt.model.RulesConfiguration;
import org.wso2.carbon.identity.input.validation.mgt.model.ValidationConfiguration;
import org.wso2.carbon.user.api.RealmConfiguration;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.UserRealm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.wso2.carbon.identity.input.validation.mgt.utils.Constants.ErrorMessages.ERROR_GETTING_EXISTING_CONFIGURATIONS;

/**
 * Abstract Field Validation Configuration Handler.
 */
public class AbstractFieldValidationConfigurationHandler implements FieldValidationConfigurationHandler {

    @Override
    public boolean canHandle(String field) {

        return true;
    }

    @Override
    public ValidationConfiguration getDefaultValidationConfiguration(String tenantDomain) throws
            InputValidationMgtException {

        return new ValidationConfiguration();
    }

    protected RulesConfiguration getRuleConfig(String validatorName, String property, String value) {

        RulesConfiguration rule = new RulesConfiguration();
        rule.setValidatorName(validatorName);
        Map<String, String> properties = new HashMap<>();
        properties.put(property, value);
        rule.setProperties(properties);

        return rule;
    }

    protected RealmConfiguration getRealmConfiguration(String tenantDomain) throws InputValidationMgtException {

        try {
            // Retrieve configs from secondary userstore if configured in the identity.xml, else from PRIMARY userstore.
            UserRealm realm = (UserRealm) CarbonContext.getThreadLocalCarbonContext().getUserRealm();
            String secondaryUserStoreName =
                    IdentityUtil.getProperty("FieldInputValidation.DefaultConfigurations.SecondaryUserStoreName");
            if (realm != null && StringUtils.isNotBlank(secondaryUserStoreName)
                    && realm.getUserStoreManager().getSecondaryUserStoreManager(secondaryUserStoreName) != null) {
                return realm.getUserStoreManager().getSecondaryUserStoreManager(
                        secondaryUserStoreName).getRealmConfiguration();
            } else if (CarbonContext.getThreadLocalCarbonContext().getUserRealm() != null &&
                    CarbonContext.getThreadLocalCarbonContext().getUserRealm().getRealmConfiguration() != null) {
                return CarbonContext.getThreadLocalCarbonContext().getUserRealm().getRealmConfiguration();
            } else {
                throw new InputValidationMgtException(ERROR_GETTING_EXISTING_CONFIGURATIONS.getCode(),
                        "Realm configuration is empty for tenant :" + tenantDomain);
            }
        } catch (UserStoreException e) {
            throw new InputValidationMgtException(ERROR_GETTING_EXISTING_CONFIGURATIONS.getCode(),
                    "Failed to get user realm for tenant :" + tenantDomain);
        }
    }

    @Override
    public boolean validateValidationConfiguration(List<RulesConfiguration> configurationList)
            throws InputValidationMgtClientException {

        return true;
    }
}
