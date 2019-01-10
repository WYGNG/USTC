//
//  secondViewController.m
//  SA18225428_2
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "secondViewController.h"
#import "ViewController.h"
@interface secondViewController ()
@property (weak, nonatomic) IBOutlet UITextField *SA428_text;
@property (weak, nonatomic) IBOutlet UIButton *SA428_button_up;
@property (weak, nonatomic) IBOutlet UIButton *SA428_button_down;

@end

@implementation secondViewController

- (void)viewDidLoad {
    
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    
}
- (void)viewWillAppear:(BOOL)animated{
    //NSInteger * num = self.ns.length;
    NSLog(@"%lu",self.ns.length);
    NSString * string = [NSString stringWithFormat:@"%ld",(long)self.ns.length];
    _SA428_text.text = string;
}
/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/
- (IBAction)up:(id)sender {
    NSMutableString * string = [NSMutableString stringWithFormat:@"%@", [self.ns capitalizedString]];
    self.ns = [NSString stringWithFormat:@"%@", string];
    ViewController *vc = [self.storyboard instantiateViewControllerWithIdentifier:@"firstview"];
    vc.string = self.ns;
    [self.navigationController pushViewController:vc animated:YES];
}

- (IBAction)down:(id)sender {
    NSMutableString * string = [NSMutableString stringWithFormat:@"%@", [self.ns lowercaseString]];
    self.ns = [NSString stringWithFormat:@"%@", string];
    ViewController *vc = [self.storyboard instantiateViewControllerWithIdentifier:@"firstview"];
    vc.string = self.ns;
    [self.navigationController pushViewController:vc animated:YES];
}




@end
