import math
pi = math.pi
def main():
	print("成绩转换程序")
	while True:
		print("------------------")
		input_val = eval(input("输入成绩:"))
		if input_val < 0 or input_val > 5:
			print("不合法的输入")
			
		if(input_val==5):
			print('A')
		elif(input_val==4):
			print('B')
		elif(input_val==3):
			print('C')
		elif(input_val==2):
			print('D')
		elif(input_val==1):
			print('E')
		elif(input_val==0):
			print('F')

if __name__ == "__main__":		
	main()