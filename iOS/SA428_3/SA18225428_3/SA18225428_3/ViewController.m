//
//  ViewController.m
//  SA18225428_3
//
//  Created by XQ on 2019/1/10.
//  Copyright © 2019 XQ. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (weak, nonatomic) IBOutlet UIImageView *sa428_img1;
@property (weak, nonatomic) IBOutlet UIImageView *sa428_img2;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    [self imageLoadPath:@"https://img.zcool.cn/community/01e7935af2ad47a801216045f03bd4.png@1280w_1l_2o_100sh.png" ImageView:self.sa428_img1 isSleeped:NO];
    [self imageLoadPath:@"https://img.zcool.cn/community/01220d5af2ad6aa801207ab44903a3.png@1280w_1l_2o_100sh.png" ImageView:self.sa428_img2 isSleeped:NO];
}

- (void) imageLoadPath:(NSString *) path ImageView:(UIImageView *) imageview isSleeped:(BOOL) tag{
    dispatch_queue_t queue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0);
    dispatch_async(queue, ^{
        
        
        NSURL * urlstr = [NSURL URLWithString:path];
        NSData * data = [NSData dataWithContentsOfURL:urlstr];
        UIImage * image = [UIImage imageWithData:data];
        
        [imageview performSelectorOnMainThread:@selector(setImage:) withObject:image waitUntilDone:NO];
        if(tag){
            [NSThread sleepForTimeInterval:3.0];
        }
        dispatch_async(dispatch_get_main_queue(), ^{imageview.image = image;});
    });
    
    
    
}

@end
