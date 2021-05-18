# 排序算法
## [排序模板](../src/main/java/lin/xc/coding/skill/algorithm/sort/Example.java)
## [选择排序](../src/main/java/lin/xc/coding/skill/algorithm/sort/Selecton.java)
## [插入排序](../src/main/java/lin/xc/coding/skill/algorithm/sort/Insertion.java)
通常人们整理桥牌的方法是一张一张来，将每一张牌插入到其它已经有序的牌中的位置。在计算机的实验中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。这种算法叫做插入排序。
<br>
与选择排序一样，当前索引左边的所有元素都是有序的，但它们的最终位置还不确定，为了给更小的元素腾出空间，它们可能会被移动。但是当索引到达数组的右端时，数组排序就完成了。
<br>
sort为核心方法，按升序排序，一次比较每一个元素，每一个元素向左比较至数组最左端，若小于左边元素，则交换位置，反之则跳出循环，进行下一个元素的比较。
