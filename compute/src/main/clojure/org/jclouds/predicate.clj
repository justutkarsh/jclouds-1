;
;
; Copyright (C) 2011 Cloud Conscious, LLC. <info@cloudconscious.com>
;
; ====================================================================
; Licensed under the Apache License, Version 2.0 (the "License");
; you may not use this file except in compliance with the License.
; You may obtain a copy of the License at
;
; http://www.apache.org/licenses/LICENSE-2.0
;
; Unless required by applicable law or agreed to in writing, software
; distributed under the License is distributed on an "AS IS" BASIS,
; WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
; See the License for the specific language governing permissions and
; limitations under the License.
; ====================================================================
;
(ns org.jclouds.predicate)

(defprotocol Predicate
  "Protocol for making a com.google.common.base.Predicate."
  (to-predicate [p]))

(extend-protocol Predicate
  clojure.lang.IFn
  (to-predicate [p]
    (reify com.google.common.base.Predicate
      (apply [this input] (p input))))

  com.google.common.base.Predicate
  (to-predicate [p] p))