/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.openwhisk.intellij.common.whisk.model.action;

import org.apache.openwhisk.intellij.common.whisk.model.Limits;
import org.apache.openwhisk.intellij.common.whisk.model.exec.ExecMetaData;
import org.apache.openwhisk.intellij.explorer.editor.model.ComboBoxEntityEntry;
import org.apache.openwhisk.intellij.explorer.editor.model.ComboBoxEntityType;

import java.util.List;
import java.util.Map;

public class WhiskActionMetaData extends WhiskAction<ExecMetaData> {
    public WhiskActionMetaData() {
    }

    public WhiskActionMetaData(String name, String namespace, String version, long updated, boolean publish,
                               List<Map<String, Object>> annotations,
                               Limits limits,
                               ExecMetaData exec) {
        super(name, namespace, version, updated, publish, annotations, limits, exec);
    }

    @Override
    public String toString() {
        return getWhiskPackage().map(pkg -> pkg + "/" + getName()).orElse(getName());
    }

    public ComboBoxEntityEntry toCombBoxEntityEntry() {
        return new ComboBoxEntityEntry(toString(), ComboBoxEntityType.ACTION);
    }
}
