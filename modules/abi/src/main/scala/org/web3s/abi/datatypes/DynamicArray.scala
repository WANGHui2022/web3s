package org.web3s.abi.datatypes

import izumi.reflect.Tag

object DynamicArray:
  
  // def encode[T <: SolidityType[_] : Tag]( value: DynamicArray[T]): String =
  //   def encodeArrayValuesOffsets(value: DynamicArray[T]) : String = ???
  //   def encodeArrayValues(value: Array[T]) : String = ???
  //   encode(SolidityUInt.encode(new SolidityUInt(BigInt(value.values.size))) ++ 
  //     Array
  
end DynamicArray


class DynamicArray[T <: SolidityType[_] : Tag](val values: List[T]) extends SolidityArray[T](values) :

  override def bytes32PaddedLength: Int = super.bytes32PaddedLength + SolidityType.MAX_BYTE_LENGTH

  override def getTypeAsString: String = values.map(_.getTypeAsString).mkString("[", ",", "]")

  

end DynamicArray
