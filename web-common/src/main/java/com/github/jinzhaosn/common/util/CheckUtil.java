/*
 * Copyright 2021-2022 COOKBIT
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jinzhaosn.common.util;

import com.github.jinzhaosn.common.exception.VerifyException;

import java.util.function.Supplier;

/**
 * 检查工具类
 *
 * @auther 961374431@qq.com
 * @date 2021年12月19日
 */
public class CheckUtil {
    private CheckUtil() {

    }

    /**
     * 检查是否为真
     *
     * @param checked 是否为真
     * @param message 不为真异常消息
     */
    public static void checkTrue(boolean checked, String message) {
        if (!checked) {
            throw new VerifyException(message);
        }
    }

    /**
     * 检查参数
     *
     * @param checked 检查结果
     * @param message 抛出异常信息
     */
    public static void checkArgument(boolean checked, String message) {
        if (!checked) {
            throw new IllegalArgumentException(message);
        }
    }
}