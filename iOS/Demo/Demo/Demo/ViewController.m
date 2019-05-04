//
//  ViewController.m
//  Demo
//
//  Created by XQ on 2018/11/30.
//  Copyright © 2018 XQ. All rights reserved.
//

#import "ViewController.h"
#import "HaloCodes.h"
@interface ViewController ()
@property (weak, nonatomic) IBOutlet UILabel *Label;
@property (weak, nonatomic) IBOutlet UITextField *Text;
@property (weak, nonatomic) IBOutlet UIButton *Button;


@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}


- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    if(textField == self.Text){
        [textField resignFirstResponder];
        return YES;
    }
    return NO;//失去焦点
}

- (IBAction)buttonCLick{
    NSString * str = [HaloCodes sayHaloCodes];
    [self.Label setText:str];
    [self.Text setText:str];
}

@end
