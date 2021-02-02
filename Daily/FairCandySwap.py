from typing import List
class Test:
    def fairCandySwap(self, A: List[int], B: List[int]) -> List[int]:
       # 遍历两个数字求的合
       sumA,sumB = sum(A),sum(B)
       # 得到需要的中间值
       count = (sumA-sumB)//2
       setA = set(A)
       ans = None
       for y in B:
           x = y+count
           if x in setA:
               ans = [x,y]
               break
       return ans


