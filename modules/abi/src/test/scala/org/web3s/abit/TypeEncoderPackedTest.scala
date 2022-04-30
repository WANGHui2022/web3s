
package org.web3s.abit

import org.scalatest.funsuite.AnyFunSuite
import org.web3s.abi.datatypes.*
import org.web3s.abi.datatypes.generated.*
import org.web3s.abi.datatypes.primitive.*
import org.web3s.abi.{Encodable, TypeEncoder}

class TypeEncoderPackedTest extends AnyFunSuite :
  test("AddressEncodePacked") {
    val address = new Address("0x663e27AdC18d862dA9A82f060310621D379e469a")
    assert("663e27adc18d862da9a82f060310621d379e469a" == TypeEncoder.encodePacked(address))
    val addressLong = new Address(256, "0xa04462684b510796c186d19abfa6929742f79394583d6efb1243bbb473f21d9f")
    assert("a04462684b510796c186d19abfa6929742f79394583d6efb1243bbb473f21d9f" == TypeEncoder.encodePacked(addressLong))
  }

  test("BoolEncodePacked") {
    assert(TypeEncoder.encodePacked(new Bool(false)) == "00")
    assert(TypeEncoder.encodePacked(new Bool(true)) == "01")
  }


  test("UintEncodePacked") {
    val zero8 = new UInt8(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero8) == "00")
    val max8 = new UInt8(255)
    assert(summon[Encodable[NumericType]].encodePacked(max8) == "ff")
    val zero16 = new UInt16(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero16) == "0000")
    val max16 = new UInt16(65535)
    assert(summon[Encodable[NumericType]].encodePacked(max16) == "ffff")
    val zero24 = new UInt24(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero24) == "000000")
    val max24 = new UInt24(16777215)
    assert(summon[Encodable[NumericType]].encodePacked(max24) == "ffffff")
    val zero32 = new UInt32(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero32) == "00000000")
    val max32 = new UInt32(BigInt(4294967295L))
    assert(summon[Encodable[NumericType]].encodePacked(max32) == "ffffffff")
    val zero40 = new UInt40(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero40) == "0000000000")
    val max40 = new UInt40(BigInt(1099511627775L))
    assert(summon[Encodable[NumericType]].encodePacked(max40) == "ffffffffff")
    val zero48 = new UInt48(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero48) == "000000000000")
    val max48 = new UInt48(BigInt(281474976710655L))
    assert(summon[Encodable[NumericType]].encodePacked(max48) == "ffffffffffff")
    val zero56 = new UInt56(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero56) == "00000000000000")
    val max56 = new UInt56(BigInt(72057594037927935L))
    assert(summon[Encodable[NumericType]].encodePacked(max56) == "ffffffffffffff")
    val zero64 = new UInt64(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero64) == "0000000000000000")
    val maxLong = new UInt64(BigInt(Long.MaxValue))
    assert(summon[Encodable[NumericType]].encodePacked(maxLong) == "7fffffffffffffff")
    val maxValue64 = new SolidityUInt(BigInt("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff", 16))
    assert(summon[Encodable[NumericType]].encodePacked(maxValue64) == "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val largeValue = new SolidityUInt(BigInt("fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe", 16))
    assert(summon[Encodable[NumericType]].encodePacked(largeValue) == "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffe")
    val zero72 = new UInt72(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero72) == "000000000000000000")
    val max72 = new UInt72(BigInt("4722366482869645213695"))
    assert(summon[Encodable[NumericType]].encodePacked(max72) ==  "ffffffffffffffffff")
    val zero80 = new UInt80(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero80) == "00000000000000000000")
    val max80 = new UInt80(BigInt("1208925819614629174706175"))
    assert(summon[Encodable[NumericType]].encodePacked(max80) ==  "ffffffffffffffffffff")
    val zero88 = new UInt88(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero88) == "0000000000000000000000")
    val max88 = new UInt88(BigInt("309485009821345068724781055"))
    assert(summon[Encodable[NumericType]].encodePacked(max88) ==  "ffffffffffffffffffffff")
    val zero96 = new UInt96(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero96) == "000000000000000000000000")
    val max96 = new UInt96(BigInt("79228162514264337593543950335"))
    assert(summon[Encodable[NumericType]].encodePacked(max96) ==  "ffffffffffffffffffffffff")
    val zero104 = new UInt104(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero104) == "00000000000000000000000000")
    val max104 = new UInt104(BigInt("20282409603651670423947251286015"))
    assert(summon[Encodable[NumericType]].encodePacked(max104) ==  "ffffffffffffffffffffffffff")
    val zero112 = new UInt112(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero112) == "0000000000000000000000000000")
    val max112 = new UInt112(BigInt("5192296858534827628530496329220095"))
    assert(summon[Encodable[NumericType]].encodePacked(max112) ==  "ffffffffffffffffffffffffffff")
    val zero120 = new UInt120(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero120) == "000000000000000000000000000000")
    val max120 = new UInt120(BigInt("1329227995784915872903807060280344575"))
    assert(summon[Encodable[NumericType]].encodePacked(max120) ==  "ffffffffffffffffffffffffffffff")
    val zero128 = new UInt128(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero128) == "00000000000000000000000000000000")
    val max128 = new UInt128(BigInt("340282366920938463463374607431768211455"))
    assert(summon[Encodable[NumericType]].encodePacked(max128) ==  "ffffffffffffffffffffffffffffffff")
    val zero136 = new UInt136(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero136) == "0000000000000000000000000000000000")
    val max136 = new UInt136(BigInt("87112285931760246646623899502532662132735"))
    assert(summon[Encodable[NumericType]].encodePacked(max136) ==  "ffffffffffffffffffffffffffffffffff")
    val zero144 = new UInt144(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero144) == "000000000000000000000000000000000000")
    val max144 = new UInt144(BigInt("22300745198530623141535718272648361505980415"))
    assert(summon[Encodable[NumericType]].encodePacked(max144) ==  "ffffffffffffffffffffffffffffffffffff")
    val zero152 = new UInt152(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero152) == "00000000000000000000000000000000000000")
    val max152 = new UInt152(BigInt("5708990770823839524233143877797980545530986495"))
    assert(summon[Encodable[NumericType]].encodePacked(max152) ==  "ffffffffffffffffffffffffffffffffffffff")
    val zero160 = new UInt160(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero160) == "0000000000000000000000000000000000000000")
    val max160 = new UInt160(BigInt("1461501637330902918203684832716283019655932542975"))
    assert(summon[Encodable[NumericType]].encodePacked(max160) ==  "ffffffffffffffffffffffffffffffffffffffff")
    val zero168 = new UInt168(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero168) == "000000000000000000000000000000000000000000")
    val max168 = new UInt168(BigInt("374144419156711147060143317175368453031918731001855"))
    assert(summon[Encodable[NumericType]].encodePacked(max168) ==  "ffffffffffffffffffffffffffffffffffffffffff")
    val zero176 = new UInt176(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero176) == "00000000000000000000000000000000000000000000")
    val max176 = new UInt176(BigInt("95780971304118053647396689196894323976171195136475135"))
    assert(summon[Encodable[NumericType]].encodePacked(max176) == "ffffffffffffffffffffffffffffffffffffffffffff")
    val zero184 = new UInt184(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero184) == "0000000000000000000000000000000000000000000000")
    val max184 = new UInt184(BigInt("24519928653854221733733552434404946937899825954937634815"))
    assert(summon[Encodable[NumericType]].encodePacked(max184) == "ffffffffffffffffffffffffffffffffffffffffffffff")
    val zero192 = new UInt192(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero192) == "000000000000000000000000000000000000000000000000")
    val max192 = new UInt192(BigInt("6277101735386680763835789423207666416102355444464034512895"))
    assert(summon[Encodable[NumericType]].encodePacked(max192) ==  "ffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero200 = new UInt200(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero200) == "00000000000000000000000000000000000000000000000000")
    val max200 = new UInt200(BigInt("1606938044258990275541962092341162602522202993782792835301375"))
    assert(summon[Encodable[NumericType]].encodePacked(max200) == "ffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero208 = new UInt208(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero208) == "0000000000000000000000000000000000000000000000000000")
    val max208 = new UInt208(BigInt("411376139330301510538742295639337626245683966408394965837152255"))
    assert(summon[Encodable[NumericType]].encodePacked(max208) == "ffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero216 = new UInt216(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero216) == "000000000000000000000000000000000000000000000000000000")
    val max216 = new UInt216(BigInt("105312291668557186697918027683670432318895095400549111254310977535"))
    assert(summon[Encodable[NumericType]].encodePacked(max216) == "ffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero224 = new UInt224(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero224) == "00000000000000000000000000000000000000000000000000000000")
    val max224 = new UInt224(BigInt("26959946667150639794667015087019630673637144422540572481103610249215"))
    assert(summon[Encodable[NumericType]].encodePacked(max224) == "ffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero232 = new UInt232(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero232) == "0000000000000000000000000000000000000000000000000000000000")
    val max232 = new UInt232(BigInt("6901746346790563787434755862277025452451108972170386555162524223799295"))
    assert(summon[Encodable[NumericType]].encodePacked(max232) == "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero240 = new UInt240(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero240) == "000000000000000000000000000000000000000000000000000000000000")
    val max240 = new UInt240(BigInt("1766847064778384329583297500742918515827483896875618958121606201292619775"))
    assert(summon[Encodable[NumericType]].encodePacked(max240) ==  "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val zero248 = new UInt248(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero248) == "00000000000000000000000000000000000000000000000000000000000000")
    val max248 = new UInt248(BigInt("452312848583266388373324160190187140051835877600158453279131187530910662655"))
    assert(summon[Encodable[NumericType]].encodePacked(max248) ==  "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
  }

  test("IntEncodePacked") {
    val zero8 = new Int8(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero8) == "00")
    val max8 = new Int8(BigInt(127))
    assert(summon[Encodable[NumericType]].encodePacked(max8) == "7f")
    val min8 = new Int8(BigInt(-128))
    assert(summon[Encodable[NumericType]].encodePacked(min8) == "80")
    val zero16 = new Int16(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero16) == "0000")
    val max16 = new Int16(BigInt(32767))
    assert(summon[Encodable[NumericType]].encodePacked(max16) == "7fff")
    val min16 = new Int16(BigInt(-32768))
    assert(summon[Encodable[NumericType]].encodePacked(min16) == "8000")
    val zero24 = new Int24(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero24) == "000000")
    val max24 = new Int24(BigInt(8388607))
    assert(summon[Encodable[NumericType]].encodePacked(max24) == "7fffff")
    val min24 = new Int24(BigInt(-8388608))
    assert(summon[Encodable[NumericType]].encodePacked(min24) == "800000")
    val zero32 = new Int32(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero32) == "00000000")
    val max32 = new Int32(BigInt(2147483647))
    assert(summon[Encodable[NumericType]].encodePacked(max32) == "7fffffff")
    val min32 = new Int32(BigInt(-2147483648))
    assert(summon[Encodable[NumericType]].encodePacked(min32) == "80000000")
    val zero40 = new Int40(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero40) == "0000000000")
    val max40 = new Int40(BigInt(549755813887L))
    assert(summon[Encodable[NumericType]].encodePacked(max40) == "7fffffffff")
    val min40 = new Int40(BigInt(-549755813888L))
    assert(summon[Encodable[NumericType]].encodePacked(min40) == "8000000000")
    val zero48 = new Int48(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero48) == "000000000000")
    val max48 = new Int48(BigInt(140737488355327L))
    assert(summon[Encodable[NumericType]].encodePacked(max48) == "7fffffffffff")
    val min48 = new Int48(BigInt(-140737488355328L))
    assert(summon[Encodable[NumericType]].encodePacked(min48) == "800000000000")
    val zero56 = new Int56(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero56) == "00000000000000")
    val max56 = new Int56(BigInt(36028797018963967L))
    assert(summon[Encodable[NumericType]].encodePacked(max56) == "7fffffffffffff")
    val min56 = new Int56(BigInt(-36028797018963968L))
    assert(summon[Encodable[NumericType]].encodePacked(min56) == "80000000000000")
    val zero64 = new Int64(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero64) == "0000000000000000")
    val max64 = new Int64(BigInt(Long.MaxValue))
    assert(summon[Encodable[NumericType]].encodePacked(max64) == "7fffffffffffffff")
    val min64 = new Int64(BigInt(Long.MinValue))
    assert(summon[Encodable[NumericType]].encodePacked(min64) == "8000000000000000")
    val zero72 = new Int72(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero72) == "000000000000000000")
    val max72 = new Int72(BigInt("2361183241434822606847"))
    assert(summon[Encodable[NumericType]].encodePacked(max72) == "7fffffffffffffffff")
    val min72 = new Int72(BigInt("-2361183241434822606848"))
    assert(summon[Encodable[NumericType]].encodePacked(min72) == "800000000000000000")
    val zero80 = new Int80(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero80) == "00000000000000000000")
    val max80 = new Int80(BigInt("604462909807314587353087"))
    assert(summon[Encodable[NumericType]].encodePacked(max80) == "7fffffffffffffffffff")
    val min80 = new Int80(BigInt("-604462909807314587353088"))
    assert(summon[Encodable[NumericType]].encodePacked(min80) == "80000000000000000000")
    val zero88 = new Int88(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero88) == "0000000000000000000000")
    val max88 = new Int88(BigInt("154742504910672534362390527"))
    assert(summon[Encodable[NumericType]].encodePacked(max88) == "7fffffffffffffffffffff")
    val min88 = new Int88(BigInt("-154742504910672534362390528"))
    assert(summon[Encodable[NumericType]].encodePacked(min88) == "8000000000000000000000")
    val zero96 = new Int96(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero96) == "000000000000000000000000")
    val max96 = new Int96(BigInt("39614081257132168796771975167"))
    assert(summon[Encodable[NumericType]].encodePacked(max96) == "7fffffffffffffffffffffff")
    val min96 = new Int96(BigInt("-39614081257132168796771975168"))
    assert(summon[Encodable[NumericType]].encodePacked(min96) == "800000000000000000000000")
    val zero104 = new Int104(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero104) == "00000000000000000000000000")
    val max104 = new Int104(BigInt("10141204801825835211973625643007"))
    assert(summon[Encodable[NumericType]].encodePacked(max104) == "7fffffffffffffffffffffffff")
    val min104 = new Int104(BigInt("-10141204801825835211973625643008"))
    assert(summon[Encodable[NumericType]].encodePacked(min104) == "80000000000000000000000000")
    val zero112 = new Int112(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero112) == "0000000000000000000000000000")
    val max112 = new Int112(BigInt("2596148429267413814265248164610047"))
    assert(summon[Encodable[NumericType]].encodePacked(max112) == "7fffffffffffffffffffffffffff")
    val min112 = new Int112(BigInt("-2596148429267413814265248164610048"))
    assert(summon[Encodable[NumericType]].encodePacked(min112) == "8000000000000000000000000000")
    val zero120 = new Int120(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero120) == "000000000000000000000000000000")
    val max120 = new Int120(BigInt("664613997892457936451903530140172287"))
    assert(summon[Encodable[NumericType]].encodePacked(max120) == "7fffffffffffffffffffffffffffff")
    val min120 = new Int120(BigInt("-664613997892457936451903530140172288"))
    assert(summon[Encodable[NumericType]].encodePacked(min120) == "800000000000000000000000000000")
    val zero128 = new Int128(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero128) == "00000000000000000000000000000000")
    val max128 = new Int128(BigInt("170141183460469231731687303715884105727"))
    assert(summon[Encodable[NumericType]].encodePacked(max128) == "7fffffffffffffffffffffffffffffff")
    val min128 = new Int128(BigInt("-170141183460469231731687303715884105728"))
    assert(summon[Encodable[NumericType]].encodePacked(min128) == "80000000000000000000000000000000")
    val zero136 = new Int136(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero136) == "0000000000000000000000000000000000")
    val max136 = new Int136(BigInt("43556142965880123323311949751266331066367"))
    assert(summon[Encodable[NumericType]].encodePacked(max136) == "7fffffffffffffffffffffffffffffffff")
    val min136 = new Int136(BigInt("-43556142965880123323311949751266331066368"))
    assert(summon[Encodable[NumericType]].encodePacked(min136) == "8000000000000000000000000000000000")
    val zero144 = new Int144(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero144) == "000000000000000000000000000000000000")
    val max144 = new Int144(BigInt("11150372599265311570767859136324180752990207"))
    assert(summon[Encodable[NumericType]].encodePacked(max144) == "7fffffffffffffffffffffffffffffffffff")
    val min144 = new Int144(BigInt("-11150372599265311570767859136324180752990208"))
    assert(summon[Encodable[NumericType]].encodePacked(min144) == "800000000000000000000000000000000000")
    val zero152 = new Int152(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero152) == "00000000000000000000000000000000000000")
    val max152 = new Int152(BigInt("2854495385411919762116571938898990272765493247"))
    assert(summon[Encodable[NumericType]].encodePacked(max152) == "7fffffffffffffffffffffffffffffffffffff")
    val min152 = new Int152(BigInt("-2854495385411919762116571938898990272765493248"))
    assert(summon[Encodable[NumericType]].encodePacked(min152) == "80000000000000000000000000000000000000")
    val zero160 = new Int160(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero160) == "0000000000000000000000000000000000000000")
    val max160 = new Int160(BigInt("730750818665451459101842416358141509827966271487"))
    assert(summon[Encodable[NumericType]].encodePacked(max160) == "7fffffffffffffffffffffffffffffffffffffff")
    val min160 = new Int160(BigInt("-730750818665451459101842416358141509827966271488"))
    assert(summon[Encodable[NumericType]].encodePacked(min160) == "8000000000000000000000000000000000000000")
    val zero168 = new Int168(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero168) == "000000000000000000000000000000000000000000")
    val max168 = new Int168(BigInt("187072209578355573530071658587684226515959365500927"))
    assert(summon[Encodable[NumericType]].encodePacked(max168) == "7fffffffffffffffffffffffffffffffffffffffff")
    val min168 = new Int168(BigInt("-187072209578355573530071658587684226515959365500928"))
    assert(summon[Encodable[NumericType]].encodePacked(min168) == "800000000000000000000000000000000000000000")
    val zero176 = new Int176(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero176) == "00000000000000000000000000000000000000000000")
    val max176 = new Int176(BigInt("47890485652059026823698344598447161988085597568237567"))
    assert(summon[Encodable[NumericType]].encodePacked(max176) == "7fffffffffffffffffffffffffffffffffffffffffff")
    val min176 = new Int176(BigInt("-47890485652059026823698344598447161988085597568237568"))
    assert(summon[Encodable[NumericType]].encodePacked(min176) == "80000000000000000000000000000000000000000000")
    val zero184 = new Int184(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero184) == "0000000000000000000000000000000000000000000000")
    val max184 = new Int184(BigInt("12259964326927110866866776217202473468949912977468817407"))
    assert(summon[Encodable[NumericType]].encodePacked(max184) == "7fffffffffffffffffffffffffffffffffffffffffffff")
    val min184 = new Int184(BigInt("-12259964326927110866866776217202473468949912977468817408"))
    assert(summon[Encodable[NumericType]].encodePacked(min184) == "8000000000000000000000000000000000000000000000")
    val zero192 = new Int192(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero192) == "000000000000000000000000000000000000000000000000")
    val max192 = new Int192(BigInt("3138550867693340381917894711603833208051177722232017256447"))
    assert(summon[Encodable[NumericType]].encodePacked(max192) == "7fffffffffffffffffffffffffffffffffffffffffffffff")
    val min192 = new Int192(BigInt("-3138550867693340381917894711603833208051177722232017256448"))
    assert(summon[Encodable[NumericType]].encodePacked(min192) == "800000000000000000000000000000000000000000000000")
    val zero200 = new Int200(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero200) == "00000000000000000000000000000000000000000000000000")
    val max200 = new Int200(BigInt("803469022129495137770981046170581301261101496891396417650687"))
    assert(summon[Encodable[NumericType]].encodePacked(max200) == "7fffffffffffffffffffffffffffffffffffffffffffffffff")
    val min200 = new Int200(BigInt("-803469022129495137770981046170581301261101496891396417650688"))
    assert(summon[Encodable[NumericType]].encodePacked(min200) == "80000000000000000000000000000000000000000000000000")
    val zero208 = new Int208(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero208) == "0000000000000000000000000000000000000000000000000000")
    val max208 = new Int208(BigInt("205688069665150755269371147819668813122841983204197482918576127"))
    assert(summon[Encodable[NumericType]].encodePacked(max208) == "7fffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min208 = new Int208(BigInt("-205688069665150755269371147819668813122841983204197482918576128"))
    assert(summon[Encodable[NumericType]].encodePacked(min208) == "8000000000000000000000000000000000000000000000000000")
    val zero216 = new Int216(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero216) == "000000000000000000000000000000000000000000000000000000")
    val max216 = new Int216(BigInt("52656145834278593348959013841835216159447547700274555627155488767"))
    assert(summon[Encodable[NumericType]].encodePacked(max216) == "7fffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min216 = new Int216(BigInt("-52656145834278593348959013841835216159447547700274555627155488768"))
    assert(summon[Encodable[NumericType]].encodePacked(min216) == "800000000000000000000000000000000000000000000000000000")
    val zero224 = new Int224(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero224) == "00000000000000000000000000000000000000000000000000000000")
    val max224 = new Int224(BigInt("13479973333575319897333507543509815336818572211270286240551805124607"))
    assert(summon[Encodable[NumericType]].encodePacked(max224) == "7fffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min224 = new Int224(BigInt("-13479973333575319897333507543509815336818572211270286240551805124608"))
    assert(summon[Encodable[NumericType]].encodePacked(min224) == "80000000000000000000000000000000000000000000000000000000")
    val zero232 = new Int232(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero232) == "0000000000000000000000000000000000000000000000000000000000")
    val max232 = new Int232(BigInt("3450873173395281893717377931138512726225554486085193277581262111899647"))
    assert(summon[Encodable[NumericType]].encodePacked(max232) == "7fffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min232 = new Int232(BigInt("-3450873173395281893717377931138512726225554486085193277581262111899648"))
    assert(summon[Encodable[NumericType]].encodePacked(min232) == "8000000000000000000000000000000000000000000000000000000000")
    val zero240 = new Int240(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero240) == "000000000000000000000000000000000000000000000000000000000000")
    val max240 = new Int240(BigInt("883423532389192164791648750371459257913741948437809479060803100646309887"))
    assert(summon[Encodable[NumericType]].encodePacked(max240) == "7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min240 = new Int240(BigInt("-883423532389192164791648750371459257913741948437809479060803100646309888"))
    assert(summon[Encodable[NumericType]].encodePacked(min240) == "800000000000000000000000000000000000000000000000000000000000")
    val zero248 = new Int248(BigInt(0))
    assert(summon[Encodable[NumericType]].encodePacked(zero248) == "00000000000000000000000000000000000000000000000000000000000000")
    val max248 = new Int248(BigInt("226156424291633194186662080095093570025917938800079226639565593765455331327"))
    assert(summon[Encodable[NumericType]].encodePacked(max248) == "7fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
    val min248 = new Int248(BigInt("-226156424291633194186662080095093570025917938800079226639565593765455331328"))
    assert(summon[Encodable[NumericType]].encodePacked(min248) == "80000000000000000000000000000000000000000000000000000000000000")
    val minusOne = new SolidityInt(BigInt(-1))
    assert(summon[Encodable[NumericType]].encodePacked(minusOne) == "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff")
  }
//
  test("StaticBytesEncodePacked") {
    val staticBytes = new Bytes6(Array[Byte](0, 1, 2, 3, 4, 5))
    assert(summon[Encodable[Bytes]].encodePacked(staticBytes) == "000102030405")
    val empty = new Bytes1(Array[Byte](0))
    assert(summon[Encodable[Bytes]].encodePacked(empty) == "00")
    val ones = new Bytes1(Array[Byte](127))
    assert(summon[Encodable[Bytes]].encodePacked(ones) == "7f")
    val dave = new Bytes4("dave".getBytes)
    assert(summon[Encodable[Bytes]].encodePacked(dave) == "64617665")
  }
  //
  test("Utf8StringEncodePacked") {
    val string = new Utf8String("Hello, world!")
    assert("48656c6c6f2c20776f726c6421" == TypeEncoder.encodePacked(string))
    val largeString = new Utf8String("Very long string value for test!")
    assert("56657279206c6f6e6720737472696e672076616c756520666f72207465737421" == TypeEncoder.encodePacked(largeString))
    val veryLargeString = new Utf8String("Very long string value for test!Very long string value for test!")
    assert("56657279206c6f6e6720737472696e672076616c756520666f722074657374" + "2156657279206c6f6e6720737472696e672076616c756520666f72207465737421" == TypeEncoder.encodePacked(veryLargeString))
  }
//
//  test("StaticArrayEncodePacked"){
//    val empty = new StaticArray0[UInt16](Nil)
//    assert("" == TypeEncoder.encodePacked(empty))
//    val array = new StaticArray3[UInt16](new UInt16(0x45), new UInt16(0x7), new UInt16(65535))
//    assert("0000000000000000000000000000000000000000000000000000000000000045" + "0000000000000000000000000000000000000000000000000000000000000007" + "000000000000000000000000000000000000000000000000000000000000ffff" == TypeEncoder.encodePacked(array))
//   // val strings = new StaticArray3[Utf8String](new Utf8String("test"), new Utf8String("test"), new Utf8String("test"))
//  //  assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(strings))
////    val dynamicStuct = new StaticArray0(classOf[Nothing], new Nothing("", ""), new Nothing("id", "name"), new Nothing("", ""))
////    assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(dynamicStuct))
////    val staticStruct = new StaticArray0(classOf[Nothing], new Nothing(BigInteger.ONE, BigInteger.ZERO), new Nothing(BigInteger.ONE, BigInteger.ZERO), new Nothing(BigInteger.ONE, BigInteger.ZERO))
////    assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(staticStruct))
////    val ufixed = new StaticArray0(classOf[Nothing], new Nothing(BigInteger.valueOf(0x2), BigInteger.valueOf(0x2)), new Nothing(BigInteger.valueOf(0x8), BigInteger.valueOf(0x8)))
////    assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(ufixed))
////    val fixed = new StaticArray0(classOf[Nothing], new Nothing(BigInteger.valueOf(0x2), BigInteger.valueOf(0x2)), new Nothing(BigInteger.valueOf(0x8), BigInteger.valueOf(0x8)))
////    assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(fixed))
////    val arrayOfEmptyBytes = new StaticArray0(classOf[Nothing], new Nothing(new Array[Byte](0)), new Nothing(new Array[Byte](0)))
////    .assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(arrayOfEmptyBytes))
//  }
//
  test("DynamicBytesEncodePacked") {
    val dynamicBytes = new DynamicBytes(Array[Byte](0, 1, 2, 3, 4, 5))
    assert("0001020304050000000000000000000000000000000000000000000000000000" == TypeEncoder.encodePacked(dynamicBytes))
    val empty = new DynamicBytes(Array[Byte](0))
    assert("0000000000000000000000000000000000000000000000000000000000000000" == TypeEncoder.encodePacked(empty))
    val dave = new DynamicBytes("dave".getBytes)
    assert("6461766500000000000000000000000000000000000000000000000000000000" == TypeEncoder.encodePacked(dave))
    val loremIpsum = new DynamicBytes(("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " + "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim " + "veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex " + "ea commodo consequat. Duis aute irure dolor in reprehenderit in " + "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur " + "sint occaecat cupidatat non proident, sunt in culpa qui officia " + "deserunt mollit anim id est laborum.").getBytes)
    assert("4c6f72656d20697073756d20646f6c6f722073697420616d65742c20636f6e73" + "656374657475722061646970697363696e6720656c69742c2073656420646f20" + "656975736d6f642074656d706f7220696e6369646964756e74207574206c6162" + "6f726520657420646f6c6f7265206d61676e6120616c697175612e2055742065" + "6e696d206164206d696e696d2076656e69616d2c2071756973206e6f73747275" + "6420657865726369746174696f6e20756c6c616d636f206c61626f726973206e" + "69736920757420616c697175697020657820656120636f6d6d6f646f20636f6e" + "7365717561742e2044756973206175746520697275726520646f6c6f7220696e" + "20726570726568656e646572697420696e20766f6c7570746174652076656c69" + "7420657373652063696c6c756d20646f6c6f726520657520667567696174206e" + "756c6c612070617269617475722e204578636570746575722073696e74206f63" + "63616563617420637570696461746174206e6f6e2070726f6964656e742c2073" + "756e7420696e2063756c706120717569206f666669636961206465736572756e" + "74206d6f6c6c697420616e696d20696420657374206c61626f72756d2e000000" == TypeEncoder.encodePacked(loremIpsum))
  }
//
//  test("DynamicArrayEncodePacked"){
//    val empty = new Nothing(classOf[Nothing])
//    assert("", TypeEncoder.encodePacked(empty))
//    val array = new Nothing(classOf[Nothing], new Nothing(BigInteger.ONE), new Nothing(BigInteger.valueOf(2)), new Nothing(BigInteger.valueOf(3)))
//    assert("0000000000000000000000000000000000000000000000000000000000000001" + "0000000000000000000000000000000000000000000000000000000000000002" + "0000000000000000000000000000000000000000000000000000000000000003", TypeEncoder.encodePacked(array))
//    val uints = new Nothing(classOf[Nothing], new Nothing(BigInteger.ONE), new Nothing(BigInteger.valueOf(2)))
//    assert("0000000000000000000000000000000000000000000000000000000000000001" + "0000000000000000000000000000000000000000000000000000000000000002", TypeEncoder.encodePacked(uints))
//    val strings = new Nothing(classOf[Nothing], new Nothing("one"), new Nothing("two"), new Nothing("three"))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(strings))
//    val dynamicStuct = new Nothing(classOf[Nothing], new Nothing("", ""), new Nothing("id", "name"), new Nothing("", ""))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(dynamicStuct))
//    val staticStruct = new Nothing(classOf[Nothing], new Nothing(BigInteger.ONE, BigInteger.ZERO), new Nothing(BigInteger.ONE, BigInteger.ZERO), new Nothing(BigInteger.ONE, BigInteger.ZERO))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(staticStruct))
//    val ufixed = new Nothing(classOf[Nothing], new Nothing(BigInteger.valueOf(0x2), BigInteger.valueOf(0x2)), new Nothing(BigInteger.valueOf(0x8), BigInteger.valueOf(0x8)))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(ufixed))
//    val fixed = new Nothing(classOf[Nothing], new Nothing(BigInteger.valueOf(0x2), BigInteger.valueOf(0x2)), new Nothing(BigInteger.valueOf(0x8), BigInteger.valueOf(0x8)))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(fixed))
//    val arrayOfEmptyBytes = new Nothing(classOf[Nothing], new Nothing(new Array[Byte](0)), new Nothing(new Array[Byte](0)))
//    Assertions.assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(arrayOfEmptyBytes))
//  }

  test("PrimitiveByteEncodePacked") {
    assert("00" == PrimitiveType.encodePacked(PrimitiveByte(0.toByte)))
    assert("7f" == PrimitiveType.encodePacked(PrimitiveByte(127.toByte)))
  }

  test("PrimitiveCharEncodePacked") {
    assert("61" == PrimitiveType.encodePacked(PrimitiveChar('a')))
    assert("20" == PrimitiveType.encodePacked(PrimitiveChar(' ')))
  }

  test("PrimitiveIntEncodePacked") {
    assert("00000000" == PrimitiveType.encodePacked(PrimitiveInt(0)))
    assert("80000000" == PrimitiveType.encodePacked(PrimitiveInt(Int.MinValue)))
    assert("7fffffff" == PrimitiveType.encodePacked(PrimitiveInt(Int.MaxValue)))
  }

  test("PrimitiveShortEncodePacked") {
    assert("0000" == PrimitiveType.encodePacked(PrimitiveShort(0.toShort)))
    assert("8000" == PrimitiveType.encodePacked(PrimitiveShort(Short.MinValue)))
    assert("7fff" == PrimitiveType.encodePacked(PrimitiveShort(Short.MaxValue)))
  }

  test("PrimitiveLongEncodePacked") {
    assert("0000000000000000" == PrimitiveType.encodePacked(PrimitiveLong(0)))
    assert("8000000000000000" == PrimitiveType.encodePacked(PrimitiveLong(Long.MinValue)))
    assert("7fffffffffffffff" == PrimitiveType.encodePacked(PrimitiveLong(Long.MaxValue)))
  }

//  test("PrimitiveFloatEncodePacked() = assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(new Nothing(0)))
//
//  test("PrimitiveDouble() = assertThrows(classOf[UnsupportedOperationException], () => TypeEncoder.encodePacked(new Nothing(0)))
end TypeEncoderPackedTest
