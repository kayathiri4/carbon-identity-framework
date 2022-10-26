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

package org.wso2.carbon.identity.input.validation.mgt.model;

/**
 * Configuration object for Default Validator.
 */
public class DefaultValidator {

    private int min;
    private int max;

    /**
     * Method to get max.
     *
     * @return max.
     */
    public int getMax() {

        return max;
    }

    /**
     * Method to get min.
     *
     * @return  min.
     */
    public int getMin() {

        return min;
    }

    /**
     * Method to set max.
     *
     * @param max   Maximum limit.
     */
    public void setMax(int max) {

        this.max = max;
    }

    /**
     * Method to set min.
     *
     * @param min   Minimum limit.
     */
    public void setMin(int min) {

        this.min = min;
    }
}
