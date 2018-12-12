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
{Boolean flag;}
@property (weak, nonatomic) IBOutlet UIImageView *backGround;
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
//https://blog.csdn.net/u013775224/article/details/78642089
- (UIStatusBarStyle)preferredStatusBarStyle {
    return UIStatusBarStyleLightContent;
}
- (void)viewWillAppear:(BOOL)animated{
    [super viewWillAppear:animated];
    self.navigationController.navigationBar.hidden = YES;
    self.navigationController.navigationBar.barStyle = UIStatusBarStyleLightContent;
    
    UIToolbar * uitoolbar = [[UIToolbar alloc] init];
    uitoolbar.frame = self.backGround.bounds;
    uitoolbar.barStyle = UIBarStyleBlack;
    uitoolbar.alpha = 0.99;
    [self.backGround addSubview:uitoolbar];
}

//
- (void)viewDidLoad {
    [super viewDidLoad];
    flag = NO;
    // Do any additional setup after loading the view, typically from a nib.
   
    
}
/*输入*/
- (IBAction)inputNumber:(UIButton *)sender {
    NSMutableString * string = [NSMutableString stringWithString:self.TextField.text];
    
    //修复bug
    if(flag == YES){
        NSString * a = [[sender titleLabel] text];
        if([a isEqual:@"+"] || [a isEqual:@"-"] || [a isEqual:@"*"] || [a isEqual:@"/"]){
            [string appendString:[[sender titleLabel] text]];
            [self.calculator.string appendString:[[sender titleLabel] text]];
            self.TextField.text = string;
            flag = NO;
        }
       else{
            self.calculator.string = nil;
            [string appendString:[[sender titleLabel] text]];
            [self.calculator.string appendString:[[sender titleLabel] text]];
            self.TextField.text = string;
            flag = NO;
            
        }
    }
    //
    
    else{
        [string appendString:[[sender titleLabel] text]];
        [self.calculator.string appendString:[[sender titleLabel] text]];
        self.TextField.text = string;
    }

}
/*结果*/
- (IBAction)result:(UIButton *)sender {
    
    self.lastText.text = nil;
    self.lastText.text = self .calculator.returnResult;
    if([self.lastText.text  isEqual: @"Error"]){
        //UIAlertView * uialertview = [[UIAlertView alloc] initWithTitle:@"出现错误辣(>_<)" message:@"输入有误，请输入合法表达式" delegate:0 cancelButtonTitle:@"好的😯" otherButtonTitles:nil, nil];
        //[uialertview show];
        UIAlertController * uiAlertController = [UIAlertController alertControllerWithTitle:@"出现错误辣(>_<)" message:@"输入有误，请输入合法表达式" preferredStyle:UIAlertControllerStyleAlert];
        //
        UIAlertAction * uiYesAction = [UIAlertAction actionWithTitle:@"好的👌" style:UIAlertActionStyleDefault handler:^(UIAlertAction * _Nonnull action) {
            NSLog(@"好的👌");
        }];
        /*
        UIAlertAction * uiNoAction = [UIAlertAction actionWithTitle:@"不行🚫" style:UIAlertActionStyleCancel handler:^(UIAlertAction * _Nonnull action) {
            NSLog(@"不行🚫");
  
        }];
         */
        //
        [uiAlertController addAction:uiYesAction];
        //[uiAlertController addAction:uiNoAction];
        //
        [self presentViewController:uiAlertController animated:YES completion:nil];
        
        
        self.lastText.text = nil;
    }
    self.TextField.text = nil;
    flag = YES;
    
    
    
}

/*删除*/
- (IBAction)delete:(UIButton *)sender {
    if(self.TextField.text != nil){
        long length = self.calculator.string.length - 1;
        if(length >= 0){
            [self.calculator.string deleteCharactersInRange:NSMakeRange(length,1)];
            self.TextField.text = self.calculator.string;
        }
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
