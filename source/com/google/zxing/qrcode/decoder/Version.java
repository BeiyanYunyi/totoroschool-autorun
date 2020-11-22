package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

public final class Version
{
  private static final Version[] VERSIONS = buildVersions();
  private static final int[] VERSION_DECODE_INFO = { 31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017 };
  private final int[] alignmentPatternCenters;
  private final ECBlocks[] ecBlocks;
  private final int totalCodewords;
  private final int versionNumber;
  
  private Version(int paramInt, int[] paramArrayOfInt, ECBlocks... paramVarArgs)
  {
    this.versionNumber = paramInt;
    this.alignmentPatternCenters = paramArrayOfInt;
    this.ecBlocks = paramVarArgs;
    paramInt = 0;
    int j = paramVarArgs[0].getECCodewordsPerBlock();
    paramArrayOfInt = paramVarArgs[0].getECBlocks();
    int k = paramArrayOfInt.length;
    int i = 0;
    while (paramInt < k)
    {
      paramVarArgs = paramArrayOfInt[paramInt];
      i += paramVarArgs.getCount() * (paramVarArgs.getDataCodewords() + j);
      paramInt += 1;
    }
    this.totalCodewords = i;
  }
  
  private static Version[] buildVersions()
  {
    Object localObject1 = new ECBlocks(7, new ECB[] { new ECB(1, 19) });
    Object localObject2 = new ECBlocks(10, new ECB[] { new ECB(1, 16) });
    Object localObject3 = new ECBlocks(13, new ECB[] { new ECB(1, 13) });
    Object localObject4 = new ECBlocks(17, new ECB[] { new ECB(1, 9) });
    localObject1 = new Version(1, new int[0], new ECBlocks[] { localObject1, localObject2, localObject3, localObject4 });
    localObject2 = new ECBlocks(10, new ECB[] { new ECB(1, 34) });
    localObject3 = new ECBlocks(16, new ECB[] { new ECB(1, 28) });
    localObject4 = new ECBlocks(22, new ECB[] { new ECB(1, 22) });
    Object localObject5 = new ECBlocks(28, new ECB[] { new ECB(1, 16) });
    localObject2 = new Version(2, new int[] { 6, 18 }, new ECBlocks[] { localObject2, localObject3, localObject4, localObject5 });
    localObject3 = new ECBlocks(15, new ECB[] { new ECB(1, 55) });
    localObject4 = new ECBlocks(26, new ECB[] { new ECB(1, 44) });
    localObject5 = new ECBlocks(18, new ECB[] { new ECB(2, 17) });
    Object localObject6 = new ECBlocks(22, new ECB[] { new ECB(2, 13) });
    localObject3 = new Version(3, new int[] { 6, 22 }, new ECBlocks[] { localObject3, localObject4, localObject5, localObject6 });
    localObject4 = new ECBlocks(20, new ECB[] { new ECB(1, 80) });
    localObject5 = new ECBlocks(18, new ECB[] { new ECB(2, 32) });
    localObject6 = new ECBlocks(26, new ECB[] { new ECB(2, 24) });
    Object localObject7 = new ECBlocks(16, new ECB[] { new ECB(4, 9) });
    localObject4 = new Version(4, new int[] { 6, 26 }, new ECBlocks[] { localObject4, localObject5, localObject6, localObject7 });
    localObject5 = new ECBlocks(26, new ECB[] { new ECB(1, 108) });
    localObject6 = new ECBlocks(24, new ECB[] { new ECB(2, 43) });
    localObject7 = new ECBlocks(18, new ECB[] { new ECB(2, 15), new ECB(2, 16) });
    Object localObject8 = new ECBlocks(22, new ECB[] { new ECB(2, 11), new ECB(2, 12) });
    localObject5 = new Version(5, new int[] { 6, 30 }, new ECBlocks[] { localObject5, localObject6, localObject7, localObject8 });
    localObject6 = new ECBlocks(18, new ECB[] { new ECB(2, 68) });
    localObject7 = new ECBlocks(16, new ECB[] { new ECB(4, 27) });
    localObject8 = new ECBlocks(24, new ECB[] { new ECB(4, 19) });
    Object localObject9 = new ECBlocks(28, new ECB[] { new ECB(4, 15) });
    localObject6 = new Version(6, new int[] { 6, 34 }, new ECBlocks[] { localObject6, localObject7, localObject8, localObject9 });
    localObject7 = new ECBlocks(20, new ECB[] { new ECB(2, 78) });
    localObject8 = new ECBlocks(18, new ECB[] { new ECB(4, 31) });
    localObject9 = new ECBlocks(18, new ECB[] { new ECB(2, 14), new ECB(4, 15) });
    Object localObject10 = new ECBlocks(26, new ECB[] { new ECB(4, 13), new ECB(1, 14) });
    localObject7 = new Version(7, new int[] { 6, 22, 38 }, new ECBlocks[] { localObject7, localObject8, localObject9, localObject10 });
    localObject8 = new ECBlocks(24, new ECB[] { new ECB(2, 97) });
    localObject9 = new ECBlocks(22, new ECB[] { new ECB(2, 38), new ECB(2, 39) });
    localObject10 = new ECBlocks(22, new ECB[] { new ECB(4, 18), new ECB(2, 19) });
    Object localObject11 = new ECBlocks(26, new ECB[] { new ECB(4, 14), new ECB(2, 15) });
    localObject8 = new Version(8, new int[] { 6, 24, 42 }, new ECBlocks[] { localObject8, localObject9, localObject10, localObject11 });
    localObject9 = new ECBlocks(30, new ECB[] { new ECB(2, 116) });
    localObject10 = new ECBlocks(22, new ECB[] { new ECB(3, 36), new ECB(2, 37) });
    localObject11 = new ECBlocks(20, new ECB[] { new ECB(4, 16), new ECB(4, 17) });
    Object localObject12 = new ECBlocks(24, new ECB[] { new ECB(4, 12), new ECB(4, 13) });
    localObject9 = new Version(9, new int[] { 6, 26, 46 }, new ECBlocks[] { localObject9, localObject10, localObject11, localObject12 });
    localObject10 = new ECBlocks(18, new ECB[] { new ECB(2, 68), new ECB(2, 69) });
    localObject11 = new ECBlocks(26, new ECB[] { new ECB(4, 43), new ECB(1, 44) });
    localObject12 = new ECBlocks(24, new ECB[] { new ECB(6, 19), new ECB(2, 20) });
    Object localObject13 = new ECBlocks(28, new ECB[] { new ECB(6, 15), new ECB(2, 16) });
    localObject10 = new Version(10, new int[] { 6, 28, 50 }, new ECBlocks[] { localObject10, localObject11, localObject12, localObject13 });
    localObject11 = new ECBlocks(20, new ECB[] { new ECB(4, 81) });
    localObject12 = new ECBlocks(30, new ECB[] { new ECB(1, 50), new ECB(4, 51) });
    localObject13 = new ECBlocks(28, new ECB[] { new ECB(4, 22), new ECB(4, 23) });
    Object localObject14 = new ECBlocks(24, new ECB[] { new ECB(3, 12), new ECB(8, 13) });
    localObject11 = new Version(11, new int[] { 6, 30, 54 }, new ECBlocks[] { localObject11, localObject12, localObject13, localObject14 });
    localObject12 = new ECBlocks(24, new ECB[] { new ECB(2, 92), new ECB(2, 93) });
    localObject13 = new ECBlocks(22, new ECB[] { new ECB(6, 36), new ECB(2, 37) });
    localObject14 = new ECBlocks(26, new ECB[] { new ECB(4, 20), new ECB(6, 21) });
    Object localObject15 = new ECBlocks(28, new ECB[] { new ECB(7, 14), new ECB(4, 15) });
    localObject12 = new Version(12, new int[] { 6, 32, 58 }, new ECBlocks[] { localObject12, localObject13, localObject14, localObject15 });
    localObject13 = new ECBlocks(26, new ECB[] { new ECB(4, 107) });
    localObject14 = new ECBlocks(22, new ECB[] { new ECB(8, 37), new ECB(1, 38) });
    localObject15 = new ECBlocks(24, new ECB[] { new ECB(8, 20), new ECB(4, 21) });
    Object localObject16 = new ECBlocks(22, new ECB[] { new ECB(12, 11), new ECB(4, 12) });
    localObject13 = new Version(13, new int[] { 6, 34, 62 }, new ECBlocks[] { localObject13, localObject14, localObject15, localObject16 });
    localObject14 = new ECBlocks(30, new ECB[] { new ECB(3, 115), new ECB(1, 116) });
    localObject15 = new ECBlocks(24, new ECB[] { new ECB(4, 40), new ECB(5, 41) });
    localObject16 = new ECBlocks(20, new ECB[] { new ECB(11, 16), new ECB(5, 17) });
    Object localObject17 = new ECBlocks(24, new ECB[] { new ECB(11, 12), new ECB(5, 13) });
    localObject14 = new Version(14, new int[] { 6, 26, 46, 66 }, new ECBlocks[] { localObject14, localObject15, localObject16, localObject17 });
    localObject15 = new ECBlocks(22, new ECB[] { new ECB(5, 87), new ECB(1, 88) });
    localObject16 = new ECBlocks(24, new ECB[] { new ECB(5, 41), new ECB(5, 42) });
    localObject17 = new ECBlocks(30, new ECB[] { new ECB(5, 24), new ECB(7, 25) });
    Object localObject18 = new ECBlocks(24, new ECB[] { new ECB(11, 12), new ECB(7, 13) });
    localObject15 = new Version(15, new int[] { 6, 26, 48, 70 }, new ECBlocks[] { localObject15, localObject16, localObject17, localObject18 });
    localObject16 = new ECBlocks(24, new ECB[] { new ECB(5, 98), new ECB(1, 99) });
    localObject17 = new ECBlocks(28, new ECB[] { new ECB(7, 45), new ECB(3, 46) });
    localObject18 = new ECBlocks(24, new ECB[] { new ECB(15, 19), new ECB(2, 20) });
    Object localObject19 = new ECBlocks(30, new ECB[] { new ECB(3, 15), new ECB(13, 16) });
    localObject16 = new Version(16, new int[] { 6, 26, 50, 74 }, new ECBlocks[] { localObject16, localObject17, localObject18, localObject19 });
    localObject17 = new ECBlocks(28, new ECB[] { new ECB(1, 107), new ECB(5, 108) });
    localObject18 = new ECBlocks(28, new ECB[] { new ECB(10, 46), new ECB(1, 47) });
    localObject19 = new ECBlocks(28, new ECB[] { new ECB(1, 22), new ECB(15, 23) });
    Object localObject20 = new ECBlocks(28, new ECB[] { new ECB(2, 14), new ECB(17, 15) });
    localObject17 = new Version(17, new int[] { 6, 30, 54, 78 }, new ECBlocks[] { localObject17, localObject18, localObject19, localObject20 });
    localObject18 = new ECBlocks(30, new ECB[] { new ECB(5, 120), new ECB(1, 121) });
    localObject19 = new ECBlocks(26, new ECB[] { new ECB(9, 43), new ECB(4, 44) });
    localObject20 = new ECBlocks(28, new ECB[] { new ECB(17, 22), new ECB(1, 23) });
    Object localObject21 = new ECBlocks(28, new ECB[] { new ECB(2, 14), new ECB(19, 15) });
    localObject18 = new Version(18, new int[] { 6, 30, 56, 82 }, new ECBlocks[] { localObject18, localObject19, localObject20, localObject21 });
    localObject19 = new ECBlocks(28, new ECB[] { new ECB(3, 113), new ECB(4, 114) });
    localObject20 = new ECBlocks(26, new ECB[] { new ECB(3, 44), new ECB(11, 45) });
    localObject21 = new ECBlocks(26, new ECB[] { new ECB(17, 21), new ECB(4, 22) });
    Object localObject22 = new ECBlocks(26, new ECB[] { new ECB(9, 13), new ECB(16, 14) });
    localObject19 = new Version(19, new int[] { 6, 30, 58, 86 }, new ECBlocks[] { localObject19, localObject20, localObject21, localObject22 });
    localObject20 = new ECBlocks(28, new ECB[] { new ECB(3, 107), new ECB(5, 108) });
    localObject21 = new ECBlocks(26, new ECB[] { new ECB(3, 41), new ECB(13, 42) });
    localObject22 = new ECBlocks(30, new ECB[] { new ECB(15, 24), new ECB(5, 25) });
    Object localObject23 = new ECBlocks(28, new ECB[] { new ECB(15, 15), new ECB(10, 16) });
    localObject20 = new Version(20, new int[] { 6, 34, 62, 90 }, new ECBlocks[] { localObject20, localObject21, localObject22, localObject23 });
    localObject21 = new ECBlocks(28, new ECB[] { new ECB(4, 116), new ECB(4, 117) });
    localObject22 = new ECBlocks(26, new ECB[] { new ECB(17, 42) });
    localObject23 = new ECBlocks(28, new ECB[] { new ECB(17, 22), new ECB(6, 23) });
    Object localObject24 = new ECBlocks(30, new ECB[] { new ECB(19, 16), new ECB(6, 17) });
    localObject21 = new Version(21, new int[] { 6, 28, 50, 72, 94 }, new ECBlocks[] { localObject21, localObject22, localObject23, localObject24 });
    localObject22 = new ECBlocks(28, new ECB[] { new ECB(2, 111), new ECB(7, 112) });
    localObject23 = new ECBlocks(28, new ECB[] { new ECB(17, 46) });
    localObject24 = new ECBlocks(30, new ECB[] { new ECB(7, 24), new ECB(16, 25) });
    Object localObject25 = new ECBlocks(24, new ECB[] { new ECB(34, 13) });
    localObject22 = new Version(22, new int[] { 6, 26, 50, 74, 98 }, new ECBlocks[] { localObject22, localObject23, localObject24, localObject25 });
    localObject23 = new ECBlocks(30, new ECB[] { new ECB(4, 121), new ECB(5, 122) });
    localObject24 = new ECBlocks(28, new ECB[] { new ECB(4, 47), new ECB(14, 48) });
    localObject25 = new ECBlocks(30, new ECB[] { new ECB(11, 24), new ECB(14, 25) });
    Object localObject26 = new ECBlocks(30, new ECB[] { new ECB(16, 15), new ECB(14, 16) });
    localObject23 = new Version(23, new int[] { 6, 30, 54, 78, 102 }, new ECBlocks[] { localObject23, localObject24, localObject25, localObject26 });
    localObject24 = new ECBlocks(30, new ECB[] { new ECB(6, 117), new ECB(4, 118) });
    localObject25 = new ECBlocks(28, new ECB[] { new ECB(6, 45), new ECB(14, 46) });
    localObject26 = new ECBlocks(30, new ECB[] { new ECB(11, 24), new ECB(16, 25) });
    Object localObject27 = new ECBlocks(30, new ECB[] { new ECB(30, 16), new ECB(2, 17) });
    localObject24 = new Version(24, new int[] { 6, 28, 54, 80, 106 }, new ECBlocks[] { localObject24, localObject25, localObject26, localObject27 });
    localObject25 = new ECBlocks(26, new ECB[] { new ECB(8, 106), new ECB(4, 107) });
    localObject26 = new ECBlocks(28, new ECB[] { new ECB(8, 47), new ECB(13, 48) });
    localObject27 = new ECBlocks(30, new ECB[] { new ECB(7, 24), new ECB(22, 25) });
    Object localObject28 = new ECBlocks(30, new ECB[] { new ECB(22, 15), new ECB(13, 16) });
    localObject25 = new Version(25, new int[] { 6, 32, 58, 84, 110 }, new ECBlocks[] { localObject25, localObject26, localObject27, localObject28 });
    localObject26 = new ECBlocks(28, new ECB[] { new ECB(10, 114), new ECB(2, 115) });
    localObject27 = new ECBlocks(28, new ECB[] { new ECB(19, 46), new ECB(4, 47) });
    localObject28 = new ECBlocks(28, new ECB[] { new ECB(28, 22), new ECB(6, 23) });
    Object localObject29 = new ECBlocks(30, new ECB[] { new ECB(33, 16), new ECB(4, 17) });
    localObject26 = new Version(26, new int[] { 6, 30, 58, 86, 114 }, new ECBlocks[] { localObject26, localObject27, localObject28, localObject29 });
    localObject27 = new ECBlocks(30, new ECB[] { new ECB(8, 122), new ECB(4, 123) });
    localObject28 = new ECBlocks(28, new ECB[] { new ECB(22, 45), new ECB(3, 46) });
    localObject29 = new ECBlocks(30, new ECB[] { new ECB(8, 23), new ECB(26, 24) });
    Object localObject30 = new ECBlocks(30, new ECB[] { new ECB(12, 15), new ECB(28, 16) });
    localObject27 = new Version(27, new int[] { 6, 34, 62, 90, 118 }, new ECBlocks[] { localObject27, localObject28, localObject29, localObject30 });
    localObject28 = new ECBlocks(30, new ECB[] { new ECB(3, 117), new ECB(10, 118) });
    localObject29 = new ECBlocks(28, new ECB[] { new ECB(3, 45), new ECB(23, 46) });
    localObject30 = new ECBlocks(30, new ECB[] { new ECB(4, 24), new ECB(31, 25) });
    Object localObject31 = new ECBlocks(30, new ECB[] { new ECB(11, 15), new ECB(31, 16) });
    localObject28 = new Version(28, new int[] { 6, 26, 50, 74, 98, 122 }, new ECBlocks[] { localObject28, localObject29, localObject30, localObject31 });
    localObject29 = new ECBlocks(30, new ECB[] { new ECB(7, 116), new ECB(7, 117) });
    localObject30 = new ECBlocks(28, new ECB[] { new ECB(21, 45), new ECB(7, 46) });
    localObject31 = new ECBlocks(30, new ECB[] { new ECB(1, 23), new ECB(37, 24) });
    Object localObject32 = new ECBlocks(30, new ECB[] { new ECB(19, 15), new ECB(26, 16) });
    localObject29 = new Version(29, new int[] { 6, 30, 54, 78, 102, 126 }, new ECBlocks[] { localObject29, localObject30, localObject31, localObject32 });
    localObject30 = new ECBlocks(30, new ECB[] { new ECB(5, 115), new ECB(10, 116) });
    localObject31 = new ECBlocks(28, new ECB[] { new ECB(19, 47), new ECB(10, 48) });
    localObject32 = new ECBlocks(30, new ECB[] { new ECB(15, 24), new ECB(25, 25) });
    Object localObject33 = new ECBlocks(30, new ECB[] { new ECB(23, 15), new ECB(25, 16) });
    localObject30 = new Version(30, new int[] { 6, 26, 52, 78, 104, 130 }, new ECBlocks[] { localObject30, localObject31, localObject32, localObject33 });
    localObject31 = new ECBlocks(30, new ECB[] { new ECB(13, 115), new ECB(3, 116) });
    localObject32 = new ECBlocks(28, new ECB[] { new ECB(2, 46), new ECB(29, 47) });
    localObject33 = new ECBlocks(30, new ECB[] { new ECB(42, 24), new ECB(1, 25) });
    Object localObject34 = new ECBlocks(30, new ECB[] { new ECB(23, 15), new ECB(28, 16) });
    localObject31 = new Version(31, new int[] { 6, 30, 56, 82, 108, 134 }, new ECBlocks[] { localObject31, localObject32, localObject33, localObject34 });
    localObject32 = new ECBlocks(30, new ECB[] { new ECB(17, 115) });
    localObject33 = new ECBlocks(28, new ECB[] { new ECB(10, 46), new ECB(23, 47) });
    localObject34 = new ECBlocks(30, new ECB[] { new ECB(10, 24), new ECB(35, 25) });
    Object localObject35 = new ECBlocks(30, new ECB[] { new ECB(19, 15), new ECB(35, 16) });
    localObject32 = new Version(32, new int[] { 6, 34, 60, 86, 112, 138 }, new ECBlocks[] { localObject32, localObject33, localObject34, localObject35 });
    localObject33 = new ECBlocks(30, new ECB[] { new ECB(17, 115), new ECB(1, 116) });
    localObject34 = new ECBlocks(28, new ECB[] { new ECB(14, 46), new ECB(21, 47) });
    localObject35 = new ECBlocks(30, new ECB[] { new ECB(29, 24), new ECB(19, 25) });
    Object localObject36 = new ECBlocks(30, new ECB[] { new ECB(11, 15), new ECB(46, 16) });
    localObject33 = new Version(33, new int[] { 6, 30, 58, 86, 114, 142 }, new ECBlocks[] { localObject33, localObject34, localObject35, localObject36 });
    localObject34 = new ECBlocks(30, new ECB[] { new ECB(13, 115), new ECB(6, 116) });
    localObject35 = new ECBlocks(28, new ECB[] { new ECB(14, 46), new ECB(23, 47) });
    localObject36 = new ECBlocks(30, new ECB[] { new ECB(44, 24), new ECB(7, 25) });
    Object localObject37 = new ECBlocks(30, new ECB[] { new ECB(59, 16), new ECB(1, 17) });
    localObject34 = new Version(34, new int[] { 6, 34, 62, 90, 118, 146 }, new ECBlocks[] { localObject34, localObject35, localObject36, localObject37 });
    localObject35 = new ECBlocks(30, new ECB[] { new ECB(12, 121), new ECB(7, 122) });
    localObject36 = new ECBlocks(28, new ECB[] { new ECB(12, 47), new ECB(26, 48) });
    localObject37 = new ECBlocks(30, new ECB[] { new ECB(39, 24), new ECB(14, 25) });
    Object localObject38 = new ECBlocks(30, new ECB[] { new ECB(22, 15), new ECB(41, 16) });
    localObject35 = new Version(35, new int[] { 6, 30, 54, 78, 102, 126, 150 }, new ECBlocks[] { localObject35, localObject36, localObject37, localObject38 });
    localObject36 = new ECBlocks(30, new ECB[] { new ECB(6, 121), new ECB(14, 122) });
    localObject37 = new ECBlocks(28, new ECB[] { new ECB(6, 47), new ECB(34, 48) });
    localObject38 = new ECBlocks(30, new ECB[] { new ECB(46, 24), new ECB(10, 25) });
    Object localObject39 = new ECBlocks(30, new ECB[] { new ECB(2, 15), new ECB(64, 16) });
    localObject36 = new Version(36, new int[] { 6, 24, 50, 76, 102, 128, 154 }, new ECBlocks[] { localObject36, localObject37, localObject38, localObject39 });
    localObject37 = new ECBlocks(30, new ECB[] { new ECB(17, 122), new ECB(4, 123) });
    localObject38 = new ECBlocks(28, new ECB[] { new ECB(29, 46), new ECB(14, 47) });
    localObject39 = new ECBlocks(30, new ECB[] { new ECB(49, 24), new ECB(10, 25) });
    ECBlocks localECBlocks1 = new ECBlocks(30, new ECB[] { new ECB(24, 15), new ECB(46, 16) });
    localObject37 = new Version(37, new int[] { 6, 28, 54, 80, 106, 132, 158 }, new ECBlocks[] { localObject37, localObject38, localObject39, localECBlocks1 });
    localObject38 = new ECBlocks(30, new ECB[] { new ECB(4, 122), new ECB(18, 123) });
    localObject39 = new ECBlocks(28, new ECB[] { new ECB(13, 46), new ECB(32, 47) });
    localECBlocks1 = new ECBlocks(30, new ECB[] { new ECB(48, 24), new ECB(14, 25) });
    ECBlocks localECBlocks2 = new ECBlocks(30, new ECB[] { new ECB(42, 15), new ECB(32, 16) });
    localObject38 = new Version(38, new int[] { 6, 32, 58, 84, 110, 136, 162 }, new ECBlocks[] { localObject38, localObject39, localECBlocks1, localECBlocks2 });
    localObject39 = new ECBlocks(30, new ECB[] { new ECB(20, 117), new ECB(4, 118) });
    localECBlocks1 = new ECBlocks(28, new ECB[] { new ECB(40, 47), new ECB(7, 48) });
    localECBlocks2 = new ECBlocks(30, new ECB[] { new ECB(43, 24), new ECB(22, 25) });
    ECBlocks localECBlocks3 = new ECBlocks(30, new ECB[] { new ECB(10, 15), new ECB(67, 16) });
    localObject39 = new Version(39, new int[] { 6, 26, 54, 82, 110, 138, 166 }, new ECBlocks[] { localObject39, localECBlocks1, localECBlocks2, localECBlocks3 });
    localECBlocks1 = new ECBlocks(30, new ECB[] { new ECB(19, 118), new ECB(6, 119) });
    localECBlocks2 = new ECBlocks(28, new ECB[] { new ECB(18, 47), new ECB(31, 48) });
    localECBlocks3 = new ECBlocks(30, new ECB[] { new ECB(34, 24), new ECB(34, 25) });
    ECBlocks localECBlocks4 = new ECBlocks(30, new ECB[] { new ECB(20, 15), new ECB(61, 16) });
    return new Version[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localObject12, localObject13, localObject14, localObject15, localObject16, localObject17, localObject18, localObject19, localObject20, localObject21, localObject22, localObject23, localObject24, localObject25, localObject26, localObject27, localObject28, localObject29, localObject30, localObject31, localObject32, localObject33, localObject34, localObject35, localObject36, localObject37, localObject38, localObject39, new Version(40, new int[] { 6, 30, 58, 86, 114, 142, 170 }, new ECBlocks[] { localECBlocks1, localECBlocks2, localECBlocks3, localECBlocks4 }) };
  }
  
  static Version decodeVersionInformation(int paramInt)
  {
    int i = 0;
    int j = Integer.MAX_VALUE;
    int k = 0;
    while (i < VERSION_DECODE_INFO.length)
    {
      int m = VERSION_DECODE_INFO[i];
      if (m == paramInt) {
        return getVersionForNumber(i + 7);
      }
      int n = FormatInformation.numBitsDiffering(paramInt, m);
      m = j;
      if (n < j)
      {
        k = i + 7;
        m = n;
      }
      i += 1;
      j = m;
    }
    if (j <= 3) {
      return getVersionForNumber(k);
    }
    return null;
  }
  
  public static Version getProvisionalVersionForDimension(int paramInt)
    throws FormatException
  {
    if (paramInt % 4 == 1) {}
    try
    {
      Version localVersion = getVersionForNumber((paramInt - 17) / 4);
      return localVersion;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    throw FormatException.getFormatInstance();
    throw FormatException.getFormatInstance();
  }
  
  public static Version getVersionForNumber(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 40)) {
      return VERSIONS[(paramInt - 1)];
    }
    throw new IllegalArgumentException();
  }
  
  BitMatrix buildFunctionPattern()
  {
    int k = getDimensionForVersion();
    BitMatrix localBitMatrix = new BitMatrix(k);
    localBitMatrix.setRegion(0, 0, 9, 9);
    int i = k - 8;
    localBitMatrix.setRegion(i, 0, 8, 9);
    localBitMatrix.setRegion(0, i, 9, 8);
    int m = this.alignmentPatternCenters.length;
    i = 0;
    while (i < m)
    {
      int n = this.alignmentPatternCenters[i];
      int j = 0;
      while (j < m)
      {
        if (((i != 0) || ((j != 0) && (j != m - 1))) && ((i != m - 1) || (j != 0))) {
          localBitMatrix.setRegion(this.alignmentPatternCenters[j] - 2, n - 2, 5, 5);
        }
        j += 1;
      }
      i += 1;
    }
    i = k - 17;
    localBitMatrix.setRegion(6, 9, 1, i);
    localBitMatrix.setRegion(9, 6, i, 1);
    if (this.versionNumber > 6)
    {
      i = k - 11;
      localBitMatrix.setRegion(i, 0, 3, 6);
      localBitMatrix.setRegion(0, i, 6, 3);
    }
    return localBitMatrix;
  }
  
  public int[] getAlignmentPatternCenters()
  {
    return this.alignmentPatternCenters;
  }
  
  public int getDimensionForVersion()
  {
    return this.versionNumber * 4 + 17;
  }
  
  public ECBlocks getECBlocksForLevel(ErrorCorrectionLevel paramErrorCorrectionLevel)
  {
    return this.ecBlocks[paramErrorCorrectionLevel.ordinal()];
  }
  
  public int getTotalCodewords()
  {
    return this.totalCodewords;
  }
  
  public int getVersionNumber()
  {
    return this.versionNumber;
  }
  
  public String toString()
  {
    return String.valueOf(this.versionNumber);
  }
  
  public static final class ECB
  {
    private final int count;
    private final int dataCodewords;
    
    ECB(int paramInt1, int paramInt2)
    {
      this.count = paramInt1;
      this.dataCodewords = paramInt2;
    }
    
    public int getCount()
    {
      return this.count;
    }
    
    public int getDataCodewords()
    {
      return this.dataCodewords;
    }
  }
  
  public static final class ECBlocks
  {
    private final Version.ECB[] ecBlocks;
    private final int ecCodewordsPerBlock;
    
    ECBlocks(int paramInt, Version.ECB... paramVarArgs)
    {
      this.ecCodewordsPerBlock = paramInt;
      this.ecBlocks = paramVarArgs;
    }
    
    public Version.ECB[] getECBlocks()
    {
      return this.ecBlocks;
    }
    
    public int getECCodewordsPerBlock()
    {
      return this.ecCodewordsPerBlock;
    }
    
    public int getNumBlocks()
    {
      Version.ECB[] arrayOfECB = this.ecBlocks;
      int k = arrayOfECB.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += arrayOfECB[i].getCount();
        i += 1;
      }
      return j;
    }
    
    public int getTotalECCodewords()
    {
      return this.ecCodewordsPerBlock * getNumBlocks();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\qrcode\decoder\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */