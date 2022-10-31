/*
 * Copyright (c) 2022, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.input.validation.mgt.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.identity.input.validation.mgt.services.InputValidationManager;
import org.wso2.carbon.identity.input.validation.mgt.services.InputValidationManagerImpl;
import org.wso2.carbon.identity.configuration.mgt.core.ConfigurationManager;

/**
 * OSGi declarative services component which handled registration and un-registration of IdentityConsentServiceComponent.
 */

@Component(
        name = "identity.input.validation.mgt.component",
        immediate = true
)
public class InputValidationServiceComponent {

    private static final Log log = LogFactory.getLog(InputValidationServiceComponent.class);

    @Activate
    protected void activate(ComponentContext context) {

        try {
            context.getBundleContext().registerService(InputValidationManager.class.getName(),
                    new InputValidationManagerImpl(), null);
        } catch (Throwable throwable) {
            log.error("Error while activating Input Validation Service Component.", throwable);
        }
    }

    @Deactivate
    protected void deactivate(ComponentContext context) {

        log.debug("Input Validation service component deactivated.");
    }

    @Reference(
            name = "resource.configuration.manager",
            service = ConfigurationManager.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetConfigurationManager"
    )

    /**
     * This method is used to set the Configuration manager Service.
     *
     * @param configurationManager The Realm Service which needs to be set.
     */
    protected void setConfigurationManager(ConfigurationManager configurationManager) {

        InputValidationDataHolder.setConfigurationManager(configurationManager);
        log.debug("Setting the ConfigurationManager.");
    }

    /**
     * This method is used to unset the Configuration manager Service.
     *
     * @param configurationManager The Configuration manager Service which needs to unset.
     */
    protected void unsetConfigurationManager(ConfigurationManager configurationManager) {

        InputValidationDataHolder.setConfigurationManager(null);
        log.debug("Unsetting the ConfigurationManager.");
    }
}