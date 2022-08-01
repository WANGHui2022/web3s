package org.web3s.protocol.parity.methods.response

import org.web3s.protocol.core.Response
import model.FullTraceInfo

opaque type ParityFullTraceResponse = Response[FullTraceInfo]

object ParityFullTraceResponse:

  extension (x: ParityFullTraceResponse)
    def fullTraceInfo: FullTraceInfo = x.result

  def apply(response: Response[FullTraceInfo]): ParityFullTraceResponse = response

