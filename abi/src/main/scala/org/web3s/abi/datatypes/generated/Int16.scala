package org.web3s.abi.datatypes.generated

import org.web3s.abi.datatypes.EthInt

object Int16:
  val DEFAULT = Int16(BigInt(0))

final class Int16(value: BigInt) extends EthInt(16, value):
  def this(value: Long) = this(BigInt(value))
