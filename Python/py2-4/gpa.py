# gpa.py 
# Program to find student with highest GPA

class Student:
	def __init__(self, name, hours, qpoints):
		self.name = name 
		self.hours = float(hours) 
		self.qpoints = float(qpoints)
		
	def getName(self):
		return self.name
		
	def getHours(self):
		return self.hours
		
	def getQPoints(self):
		return self.qpoints
		
	def gpa(self):
		return self.qpoints/self.hours


def makeStudent(infoStr):
		name, hours, qpoints = infoStr.split("\t") 
		return Student(name, hours, qpoints)
def main():
		
		filename = "stu.txt"
		infile = open(filename, 'r')
		best = makeStudent(infile.readline())
		#找出最大GPA
		for line in infile:
			s = makeStudent(line) 
			if s.gpa() >= best.gpa():
				best = s
		#文件引用位置重置
		infile = open(filename, 'r')
		#输出最大GPA的学生信息
		for line in infile:
			i = makeStudent(line) 
			if i.gpa() == best.gpa():
				#将最后的输出语句放入if语句中，只要比当前
				print("The best student is:", i.getName()) 
				print("hours:", i.getHours()) 
				print("GPA:", i.gpa())
				 	
		infile.close()
			

if __name__ ==  "__main__":
	main()