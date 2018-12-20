//
//  advanceCalculatorViewController.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/16.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "advanceCalculatorViewController.h"

@interface advanceCalculatorViewController ()

@property (weak, nonatomic) IBOutlet UITextField *lastText_428;
@property (weak, nonatomic) IBOutlet UITextField *currentText_428;
@property (weak, nonatomic) IBOutlet UIImageView *advancebg_428;
@property (weak, nonatomic) IBOutlet UIButton *btn_left_428;
@property (weak, nonatomic) IBOutlet UIButton *btn_right_428;
@property (weak, nonatomic) IBOutlet UIButton *btn_e_428;
@property (weak, nonatomic) IBOutlet UIButton *btn_pi_428;

@end

@implementation advanceCalculatorViewController


- (IBAction)inputKey:(UIButton *)sender {
    NSInteger a = sender.tag;
    if(a == 1 || a== 2 || a == 3 || a == 4){
        NSMutableString * str = [NSMutableString stringWithString:self.currentText_428.text];
        if([[[sender titleLabel]text] isEqualToString:@"e"]){
            [self.cal.string appendString:@"2.7182818"];
        }
        else if([[[sender titleLabel]text] isEqualToString:@"pi"]){
            [self.cal.string appendString:@"3.1415926"];
        }
        else {
            [self.cal.string appendString: [[sender titleLabel] text]];
        }
        [str appendString:[[sender titleLabel] text]];
        self.currentText_428.text = str;
        self.cal.screen = str;
    }
    NSString * title = sender.titleLabel.text;
    if([title isEqualToString:@"sqrt"]){
        self.cal.string = [NSMutableString stringWithString:[self.cal sqrt:[self.cal returnResult]]];
        self.cal.screen = self.cal.string;
        self.currentText_428.text = self.cal.screen;
    }
        
    
    
}




- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/
- (UIStatusBarStyle)preferredStatusBarStyle {
    return UIStatusBarStyleLightContent;
}
- (void)viewWillAppear:(BOOL)animated{
    //self.navigationController.navigationBar.hidden = YES;
    //self.navigationController.navigationBar.barStyle = UIStatusBarStyleLightContent;
    
    UIToolbar * uitoolbar = [[UIToolbar alloc] init];
    uitoolbar.frame = self.advancebg_428.bounds;
    
    uitoolbar.barStyle = UIBarStyleDefault;
    uitoolbar.alpha = 0.99;
    [self.advancebg_428 addSubview:uitoolbar];
    _lastText_428.enabled= NO;
    _currentText_428.enabled = NO;
    
    self.currentText_428.text = self.cal.screen;
    
}








@end
