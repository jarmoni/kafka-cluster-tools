/*
 * Copyright 2017 Radek Gruchalski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gruchalski.kafka.scala

import org.apache.kafka.common.serialization._

/**
 * Default serde implicits.
 */
object DefaultSerdes {

  /**
   * Byte array serializer.
   */
  implicit lazy val byteArraySerializer = new ByteArraySerializer

  /**
   * Byte array deserializer.
   */
  implicit lazy val byteArrayDeserializer = new ByteArrayDeserializer

  /**
   * [[java.nio.ByteBuffer]] serializer.
   */
  implicit lazy val byteBufferSerializer = new ByteBufferSerializer

  /**
   * [[java.nio.ByteBuffer]] deserializer.
   */
  implicit lazy val byteBufferDeserializer = new ByteBufferDeserializer

  /**
   * [[org.apache.kafka.common.utils.Bytes]] serializer.
   */
  implicit lazy val bytesSerializer = new BytesSerializer

  /**
   * [[org.apache.kafka.common.utils.Bytes]] deserializer.
   */
  implicit lazy val bytesDeserializer = new BytesDeserializer

  /**
   * [[java.lang.Double]] serializer.
   */
  implicit lazy val doubleSerializer = new DoubleSerializer

  /**
   * [[java.lang.Double]] deserializer.
   */
  implicit lazy val doubleDeserializer = new DoubleDeserializer

  /**
   * [[java.lang.Integer]] serializer.
   */
  implicit lazy val integerSerializer = new IntegerSerializer

  /**
   * [[java.lang.Integer]] deserializer.
   */
  implicit lazy val integerDeserializer = new IntegerDeserializer

  /**
   * [[java.lang.Long]] serializer.
   */
  implicit lazy val longSerializer = new LongSerializer

  /**
   * [[java.lang.Long]] deserializer.
   */
  implicit lazy val longDeserializer = new LongDeserializer

  /**
   * [[java.lang.String]] serializer.
   */
  implicit lazy val stringSerializer = new StringSerializer

  /**
   * [[java.lang.String]] deserializer.
   */
  implicit lazy val stringDeserializer = new StringDeserializer

  // scala specific:

  /**
   * [[scala.Int]] serializer.
   */
  implicit lazy val intSerializer = new Serializer[Int] {
    val s = integerSerializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = s.configure(configs, isKey)
    def serialize(topic: String, data: Int): Array[Byte] = s.serialize(topic, data)
    def close() = s.close()
  }

  /**
   * [[scala.Int]] deserializer.
   */
  implicit lazy val intDeserializer = new Deserializer[Int] {
    val d = integerDeserializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = d.configure(configs, isKey)
    def deserialize(topic: String, data: Array[Byte]): Int = d.deserialize(topic, data)
    def close() = d.close()
  }

  /**
   * [[scala.Double]] serializer.
   */
  implicit lazy val scalaDoubleSerializer = new Serializer[Double] {
    val s = doubleSerializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = s.configure(configs, isKey)
    def serialize(topic: String, data: Double): Array[Byte] = s.serialize(topic, data)
    def close() = s.close()
  }

  /**
   * [[scala.Double]] deserializer.
   */
  implicit lazy val scalaDoubleDeserializer = new Deserializer[Double] {
    val d = doubleDeserializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = d.configure(configs, isKey)
    def deserialize(topic: String, data: Array[Byte]): Double = d.deserialize(topic, data)
    def close() = d.close()
  }

  /**
   * [[scala.Long]] serializer.
   */
  implicit lazy val scalaLongSerializer = new Serializer[Long] {
    val s = longSerializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = s.configure(configs, isKey)
    def serialize(topic: String, data: Long): Array[Byte] = s.serialize(topic, data)
    def close() = s.close()
  }

  /**
   * [[scala.Long]] deserializer.
   */
  implicit lazy val scalaLongDeserializer = new Deserializer[Long] {
    val d = longDeserializer
    def configure(configs: java.util.Map[String, _], isKey: Boolean): Unit = d.configure(configs, isKey)
    def deserialize(topic: String, data: Array[Byte]): Long = d.deserialize(topic, data)
    def close() = d.close()
  }

}
