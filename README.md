# Guess Number 猜數字 APP 專案增加需求實作

當使用者在三次內猜對數字時(不包括三次)，回應:

"Excellent! The number is 6" 、"超神的! 數字就是 6"


# 重玩按鈕的測試

請在原 MaterialActivityTest 的 Espresso測試類別中，加入專門測試右下方重玩的 FloatingActionButton(id為fab) 是否能在按下對話框內的 OK 按鈕後，成功重設counter計數器為 0