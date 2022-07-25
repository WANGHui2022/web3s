package org.web3s.protocol.core.methods.response

import org.web3s.protocol.core.Response
import org.web3s.protocol.core.Response.EthBigInt
import org.web3s.utils.Numeric

opaque type EthGetBlockTransactionCountByHash = Response[EthBigInt]

object EthGetBlockTransactionCountByHash:
  def apply(response: Response[EthBigInt]): EthGetBlockTransactionCountByHash = response

extension (x: EthGetBlockTransactionCountByHash)
  def transactionCount: BigInt = x.result
