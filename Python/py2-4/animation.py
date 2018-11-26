#!/usr/bin/python3
# -*- coding: utf-8 -*-

from graphics import *
from button import Button
from shot_tracker import ShotTracker
from input_dialog import InputDialog

def main():
	win = GraphWin('Animation', 640, 480, autoflush=False)
	win.setCoords(-10, -10, 210, 155)
	Line(Point(-10, 0), Point(210, 0)).draw(win)
	for x in range(0, 210, 50):
		Text(Point(x, -5), str(x)).draw(win)
		Line(Point(x, 0), Point(x, 2)).draw(win)

	while True:

		inputWin = InputDialog(45, 40, 2)
		choice = inputWin.interact()
		inputWin.close()

		if choice == 'Quit':
			break
			
		angle, vel, height = inputWin.getValues()
		shot = ShotTracker(win, angle, vel, height)

		while 0 <= shot.getY() and shot.getX() > -10 and shot.getX() <= 210:
			shot.update(1/50)
			update(50)
		# 显示最大高度
		maxHeight = "最大高度: %.2f 米" % shot.proj.maxY
		maxHeightWin = GraphWin('Max Height', 240, 180)
		Text(Point(120, 90), maxHeight).draw(maxHeightWin)
		

if __name__ == '__main__':
	main()
