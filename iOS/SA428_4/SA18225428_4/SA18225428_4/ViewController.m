//
//  ViewController.m
//  SA18225428_4
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UITextField *sa428_text1;
@property (weak, nonatomic) IBOutlet UITextField *sa428_text2;
@property (weak, nonatomic) IBOutlet UITextField *sa428_text3;
@property (weak, nonatomic) IBOutlet UIButton *sa428_button;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}



- (void)viewWillAppear:(BOOL)animated{
    self.sa428_button.layer.cornerRadius = 5;
    self.sa428_button.layer.masksToBounds = YES;
    
    
}
- (IBAction)add:(id)sender {
    for(int i = 0; i < _sa428_text1.text.length; i++){
        if([_sa428_text1.text isEqualToString:@""] || [_sa428_text2.text isEqualToString:@""]){
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
        }
        
        
        
        if([_sa428_text1.text characterAtIndex:i] < '0' || [_sa428_text1.text characterAtIndex:i] >'9' || [_sa428_text2.text characterAtIndex:i] < '0' || [_sa428_text2.text characterAtIndex:i] >'9'){
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
            _sa428_text1.text = nil;
            _sa428_text2.text = nil;
        }
        
        
    }
    
    
    
    float a = [_sa428_text1.text floatValue];
    float b = [_sa428_text2.text floatValue];
    float c = a + b;
    _sa428_text3.text = [NSString stringWithFormat:@"%f",c];
    
    
    
    
    
    
}


- (void) showalert{
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
    
}



@end
