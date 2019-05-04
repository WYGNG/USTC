//
//  HealthViewController.m
//  CalculaterGUI
//
//  Created by XQ on 2018/12/20.
//  Copyright © 2018年 XQ. All rights reserved.
//

#import "HealthViewController.h"
#import "Model/Calculator+Health.h"
@interface HealthViewController ()
@property (weak, nonatomic) IBOutlet UITextField *weight_428;
@property (weak, nonatomic) IBOutlet UITextField *height_428;
@property (weak, nonatomic) IBOutlet UITextField *advise_428;
@property (weak, nonatomic) IBOutlet UITextField *score_428;
@property (weak, nonatomic) IBOutlet UIButton *compute_428;
@property(strong,nonatomic) Calculator * cal;
@end

@implementation HealthViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.cal = [[Calculator alloc]init];
    self.advise_428.enabled = NO;
    self.score_428.enabled = NO;
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
- (void)viewWillAppear:(BOOL)animated{
    
}
- (Calculator *)cal{
    if(!_cal){
        _cal = [[Calculator alloc]init];
    }
    return _cal;
}
- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    if(textField == self.height_428 || textField == self.weight_428){
        [textField resignFirstResponder];
    }
    return YES;
}
- (IBAction)computeScore:(UIButton *)sender {
    NSString * score = [self.cal computeHealthWithHeight:self.height_428.text withWeight:self.weight_428.text];
    if([score floatValue] < 19){
        self.advise_428.text = @"太瘦了";
    }
    else if([score floatValue] < 25){
        self.advise_428.text = @"身材很好";
    }
    else if([score floatValue] < 30){
        self.advise_428.text = @"肥胖，需要锻炼";
    }
    else {
        self.advise_428.text = @"超重";
    }
    self.score_428.text = score;
}
@end
