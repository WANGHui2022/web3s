package org.web3s.abi.codec

import izumi.reflect.Tag
import org.web3s.abi.datatypes.{EthArray, EthType}

trait Encodable[T <: EthType[_]]:

  def encode(value: T): String

  def encodePacked(value: T): String

//
//trait EncodableSeq[S[_] <: EthArray[_]]:
//
//  def encode[T <: EthType[_] : Tag](value: S[T]): String
//
//  def encodePacked[T <: EthType[_] : Tag](value: S[T]): String
