/*
 * Copyright (c) 2017, the Dart project authors.
 *
 * Licensed under the Eclipse Public License v1.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.dart.server.internal.remote.processor;

import com.google.dart.server.IsEnabledConsumer;
import com.google.gson.JsonObject;
import org.dartlang.analysis.server.protocol.RequestError;

public class IsEnabledProcessor extends ResultProcessor {
  private final IsEnabledConsumer consumer;

  public IsEnabledProcessor(IsEnabledConsumer consumer) {
    this.consumer = consumer;
  }

  public void process(JsonObject resultObject, RequestError requestError) {
    if (resultObject != null) {
      consumer.isEnabled(resultObject.get("enabled").getAsBoolean());
    }
    if (requestError != null) {
      consumer.onError(requestError);
    }
  }
}
