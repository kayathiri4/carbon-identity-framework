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

package org.wso2.carbon.identity.input.validation.mgt.utils;

public class Constants {

    public static final String INPUT_VAL_CONFIG_RESOURCE_TYPE_NAME = "input-validation-mgt";
    public static final String INPUT_VAL_CONFIG_RESOURCE_NAME = "input-validation-configs";

    public static class Configs {

        // Keys for password rules validation.
        public static final String VALIDATION_TYPE = "validation.type";
        public static final String MIN_LENGTH = "min.length";
        public static final String MAX_LENGTH = "max.length";

        public static final String MIN_NUMERALS_LENGTH = "min.numerals.length";
        public static final String MAX_NUMERALS_LENGTH = "max.numerals.length";

        public static final String MIN_UPPER_CASE_LENGTH = "min.upper.case.length";
        public static final String MAX_UPPER_CASE_LENGTH = "max.upper.case.length";

        public static final String MIN_LOWER_CASE_LENGTH= "min.lower.case.length";
        public static final String MAX_LOWER_CASE_LENGTH = "max.lower.case.length";

        public static final String MIN_SPECIAL_CHR_LENGTH = "min.specials.chr.length";
        public static final String MAX_SPECIAL_CHR_LENGTH = "max.specials.chr.length";

        public static final String UNIQUE_CHR_ENABLE = "unique.chr.enable";
        public static final String UNIQUE_CHR_CASE_SENSITIVE = "unique.chr.case.sensitive";
        public static final String MIN_UNIQUE_CHR_LENGTH= "min.unique.chr.length";

        public static final String REPEATED_CHR_ENABLE = "repeated.chr.enable";
        public static final String REPEATED_CHR_CASE_SENSITIVE = "repeated.chr.case.sensitive";
        public static final String MAX_REPEATED_CHR_LENGTH = "max.repeated.chr.length";

        // Keys for password regEx validation.
        public static final String JAVA_REGEX = "java.regex";
        public static final String JS_REGEX = "js.regex";

        public static final String RULES = "rules";
        public static final String REGEX = "regEx";

        public static final String PASSWORD = "password";
        public static final String USERNAME = "username";
    }

    public enum ErrorMessages {

        // Client Errors.
        ERROR_NO_CONFIGURATIONS_FOUND("60001",
                "Input validation configurations are not found",
                "Input validation configurations are not configured for the tenant: %s"),
        ERROR_JAVA_REGEX_INVALID("60002",
                "Invalid regex pattern for Java.",
                "Invalid regex pattern provided for Java: %s"),
        ERROR_JS_REGEX_INVALID("60003",
                "Invalid regex pattern for JavaScript.",
                "Invalid regex pattern provided for JavaScript: %s"),

        ERROR_DEFAULT_MIN_MAX_MISMATCH("60004",
                "Invalid configurations.",
                "Invalid configuration values for %s as min: %d and max: %d"),
        ERROR_VALIDATION_PARAM_EMPTY("60005",
                "Invalid Request.",
                "Validation parameters or values cannot be empty for tenant domain: %s"),
        ERROR_VALIDATION_PARAM_NOT_SUPPORTED("60006",
                "Unsupported parameter.",
                "The parameter: %s is not supported."),
        ERROR_VALIDATION_REGEX_MISMATCH("60007",
                "REGEX_MISMATCH",
                "The %s does not match the regex: %s"),
        ERROR_VALIDATION_MIN_LENGTH_MISMATCH("60008",
                "MIN_LENGTH_NOT_SATISFIED",
                "The minimum length of %s should be %d."),
        ERROR_VALIDATION_MAX_LENGTH_MISMATCH("60009",
                "MAX_LENGTH_NOT_SATISFIED",
                "The maximum length of %s can be %d"),
        ERROR_VALIDATION_MIN_NUMERALS_LENGTH_MISMATCH("60010",
                "MIN_NUMERALS_LENGTH_NOT_SATISFIED",
                "The %s should contain at least %d digits."),
        ERROR_VALIDATION_MAX_NUMERALS_LENGTH_MISMATCH("60011",
                "MAX_NUMERALS_LENGTH_NOT_SATISFIED",
                "The %s can contain only %d digits."),
        ERROR_VALIDATION_MIN_UPPER_CASE_LENGTH_MISMATCH("60012",
                "MIN_UPPER_CASE_LENGTH_NOT_SATISFIED",
                "The %s should contain at least %d upper case characters."),
        ERROR_VALIDATION_MAX_UPPER_CASE_LENGTH_MISMATCH("60013",
                "MAX_UPPER_CASE_LENGTH_NOT_SATISFIED",
                "The %s can contain only %d upper case characters."),
        ERROR_VALIDATION_MIN_LOWER_CASE_LENGTH_MISMATCH("60014",
                "MIN_LOWER_CASE_LENGTH_NOT_SATISFIED",
                "The %s should contain at least %d lower case characters."),
        ERROR_VALIDATION_MAX_LOWER_CASE_LENGTH_MISMATCH("60015",
                "MAX_LOWER_CASE_LENGTH_NOT_SATISFIED",
                "The %s can contain only %d lower case characters."),
        ERROR_VALIDATION_MIN_SPECIAL_CHR_LENGTH_MISMATCH("60016",
                "MIN_SPECIAL_CHARACTER_LENGTH_NOT_SATISFIED",
                "The %s should contain at least %d special characters."),
        ERROR_VALIDATION_MAX_SPECIAL_CHR_LENGTH_MISMATCH("60017",
                "MAX_SPECIAL_CHARACTER_LENGTH_NOT_SATISFIED",
                "The %s can contain only %d special characters."),
        ERROR_VALIDATION_UNIQUE_CHR_MISMATCH("60018",
                "MIN_UNIQUE_CHARACTER_LENGTH_NOT_SATISFIED",
                "The %s should contain at least %d unique characters."),
        ERROR_VALIDATION_REPETITIVE_CHR_MISMATCH("60019",
                "MAX_CONSECUTIVE_CHARACTER_LENGTH_NOT_SATISFIED",
                "The %s can contain only %d consecutive characters."),
        // Server Errors.
        ERROR_GETTING_EXISTING_CONFIGURATIONS("65001",
                "Unable to get input validation configurations.",
                "Error occurred while getting the input validation configurations for the tenant: %s"),
        ERROR_WHILE_ADDING_CONFIGURATIONS("65002",
                "Unable to add the configurations.",
                "Error occurred while adding the input validation configurations for the tenant: %s"),
        ERROR_WHILE_UPDATING_CONFIGURATIONS("65003",
                "Unable to update configurations.",
                "Error occurred while updating the input validation configurations for the tenant: %s");


        private final String code;
        private final String message;
        private final String description;

        ErrorMessages(String code, String message, String description) {

            this.code = code;
            this.message = message;
            this.description = description;
        }

        /**
         * Return the error code.
         *
         * @return Code.
         */
        public String getCode() {

            return code;
        }

        /**
         * Return the error message.
         *
         * @return Message.
         */
        public String getMessage() {

            return message;
        }

        /**
         * Return the error description.
         *
         * @return Description.
         */
        public String getDescription() {

            return description;
        }

        @Override
        public String toString() {

            return code + " | " + message;
        }
    }
}
