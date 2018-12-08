//
//  ViewController.m
//  HaloCodesGUI
//
//  Created by XQ on 2018/12/8.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "ViewController.h"
#import "model/HaloCodes.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UILabel *label;
@property (weak, nonatomic) IBOutlet UITextField *text;
@property (weak, nonatomic) IBOutlet UIButton *btn1;
@property (weak, nonatomic) IBOutlet UIButton *btn2;
@property (weak, nonatomic) IBOutlet UIButton *btn3;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}
- (IBAction)clickButton1:(UIButton *)sender {
    self.label.text = [HaloCodes sayHaloCodes];
    
    
}

- (IBAction)clickButton2:(UIButton *)sender {
    HaloCodes * halocodes = [[HaloCodes alloc] init];
    self.label.text = [halocodes sayHalo:@"iOS Codes"];
}
- (IBAction)clickButton3:(UIButton *)sender {
    HaloCodes * halocodes = [[HaloCodes alloc] init];
    
    halocodes.something = self.text.text;
    self.label.text = [halocodes saySomething];
}




@end
