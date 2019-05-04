//
//  ViewController.m
//  SA18225428_1
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *sa428_text;
@property (weak, nonatomic) IBOutlet UIButton *sa428_button_red;
@property (weak, nonatomic) IBOutlet UIButton *sa428_button_yellow;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    
}
- (IBAction)red:(id)sender {
    self.sa428_text.backgroundColor = [UIColor redColor];
    
    
}

- (IBAction)yellow:(id)sender {
    self.sa428_text.backgroundColor = [UIColor yellowColor];
}


- (void)touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event{
    
    [self.sa428_text resignFirstResponder];
}
- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    if(textField == self.sa428_text)
    [textField resignFirstResponder];
    return YES;
}






@end
