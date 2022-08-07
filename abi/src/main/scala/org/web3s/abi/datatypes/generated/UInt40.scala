package org.web3s.abi.datatypes.generated

import org.web3s.abi.datatypes.EthUInt

object UInt40:
  val DEFAULT = UInt40(BigInt(0))

final class UInt40(value: BigInt) extends EthUInt(40, value):
  def this(value: Long) = this(BigInt(value))
