package org.web3s.abi.datatypes.generated

import org.web3s.abi.datatypes.EthInt

object Int200:
  val DEFAULT = Int200(BigInt(0))

final class Int200(value: BigInt) extends EthInt(200, value):
  def this(value: Long) = this(BigInt(value))
