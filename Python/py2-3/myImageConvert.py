from graphics import *

class MyImageConvert(object):
    def __init__(self,filename='test.gif'):
        self.image = Image(Point(150,150),filename)
        width = self.image.getWidth()
        height = self.image.getHeight()
        self.background = GraphWin('彩色图',width * 1.2, height * 1.2)

    def showImage(self):
        self.image.undraw()
        self.image.draw(self.background)

    def convertImage(self):
        text = Text(Point(200,20),'点击进行转换')
        text.draw(self.background)
        self.background.getMouse()
        text.undraw()
        text = Text(Point(200,20),'正在转换~~~')
        text.draw(self.background)
        img = self.image
        for x in range(img.getHeight()):
            for y in range(img.getWidth()):
                r, g, b = img.getPixel(x, y)
                grayscale = int(round(0.299 * r + 0.587 * g + 0.114 * b))
                img.setPixel(x, y, color_rgb(grayscale, grayscale, grayscale))
        text.undraw()
        text = Text(Point(200, 20), '转换完成,单击鼠标进入保存窗口')
        text.draw(self.background)
        self.background.getMouse()

        text.undraw()

    def saveImage(self):

        grayWindow = GraphWin("灰度图",400,400)
        Text(Point(200,200),'输入文件名').draw(grayWindow)
        Text(Point(200,250),'点击空白处退出').draw(grayWindow)
        Text(Point(250, 200), '.gif').draw(grayWindow)
        input = Entry(Point(200,200),10)
        input.setText("灰度图")
        input.draw(grayWindow)
        grayWindow.getMouse()
        filename = input.getText()
        self.image.save(filename + '.gif')

if __name__ == '__main__':
    #新建对象
    myImageConvert = MyImageConvert()
    #显示
    myImageConvert.showImage()
    #转换
    myImageConvert.convertImage()
    #保存
    myImageConvert.saveImage()