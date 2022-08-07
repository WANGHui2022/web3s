package org.web3s.abi.datatypes.generated

import org.web3s.abi.datatypes.EthInt

object Int24:
  val DEFAULT = Int24(BigInt(0))

final class Int24(value: BigInt) extends EthInt(24, value):
  def this(value: Long) = this(BigInt(value))
