//
//  ViewController.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/9.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "ViewController.h"
#import "Model/Calculator.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *TextField;
@property (weak, nonatomic) IBOutlet UITextField *lastText;

@property (weak, nonatomic) IBOutlet UIButton *Button1;
@property (weak, nonatomic) IBOutlet UIButton *Button2;
@property (weak, nonatomic) IBOutlet UIButton *Button3;
@property (weak, nonatomic) IBOutlet UIButton *Button4;
@property (weak, nonatomic) IBOutlet UIButton *Button5;
@property (weak, nonatomic) IBOutlet UIButton *Button6;
@property (weak, nonatomic) IBOutlet UIButton *Button7;
@property (weak, nonatomic) IBOutlet UIButton *Button8;
@property (weak, nonatomic) IBOutlet UIButton *Button9;
@property (weak, nonatomic) IBOutlet UIButton *Button0;

@property (weak, nonatomic) IBOutlet UIButton *Buttondot;

@property (weak, nonatomic) IBOutlet UIButton *Buttonadd;
@property (weak, nonatomic) IBOutlet UIButton *Buttonsub;
@property (weak, nonatomic) IBOutlet UIButton *Buttonmul;
@property (weak, nonatomic) IBOutlet UIButton *Buttondiv;

@property (weak, nonatomic) IBOutlet UIButton *Buttonclear;
@property (weak, nonatomic) IBOutlet UIButton *Buttondelete;
@property (weak, nonatomic) IBOutlet UIButton *Buttonreverse;

@property (strong,nonatomic) Calculator * calculator;
@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}
/*输入*/
- (IBAction)inputNumber:(UIButton *)sender {
    
    NSMutableString * string = [NSMutableString stringWithString:self.TextField.text];
    [self.calculator.string appendString:[[sender titleLabel] text]];
    [string appendString:[[sender titleLabel] text]];
    self.TextField.text = string;
}
/*结果*/
- (IBAction)result:(UIButton *)sender {
    self.lastText.text = nil;
    self.lastText.text = self .calculator.returnResult;
    self.TextField.text = nil;

}

/*删除*/
- (IBAction)delete:(UIButton *)sender {
    long length = self.calculator.string.length - 1;
    if(length >= 0){
        [self.calculator.string deleteCharactersInRange:NSMakeRange(length,1)];
        self.TextField.text = self.calculator.string;
    }
    //[self.calculator deleteNumber];
}


/*清除*/
- (IBAction)clear:(UIButton *)sender {
    self.TextField.text = nil;
    self.lastText.text = nil;
    [self.calculator clearString];
}
- (Calculator *)calculator{
    if(!_calculator){
        _calculator = [[Calculator alloc] init];
       
    }
     return _calculator;
}
- (IBAction)reverse:(UIButton *)sender {
    NSMutableString * string = [NSMutableString stringWithString:self.TextField.text];
    [self.calculator.string insertString:@"-" atIndex:0];
    [string insertString:@"-" atIndex:0];
    self.TextField.text = string;
}

@end
