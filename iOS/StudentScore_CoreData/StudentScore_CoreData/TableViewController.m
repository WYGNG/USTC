//
//  TableViewController.m
//  StudentScore_CoreData
//
//  Created by XQ on 2019/1/4.
//  Copyright © 2019年 XQ. All rights reserved.
//
#import "ViewController.h"
#import "TableViewController.h"
#import "AppDelegate.h"
#import "CoreData/Student+CoreDataClass.h"
#import "CoreData/Teacher+CoreDataClass.h"
@interface TableViewController ()
@property (strong, nonatomic) NSManagedObjectContext * context;
@property (strong, nonatomic) NSMutableArray * students;
@property (strong, nonatomic) Student * student;
@property (strong, nonatomic) Teacher * teacher;
@end

@implementation TableViewController
- (NSManagedObjectContext *)context{
    
    if(!_context){
        AppDelegate * coreDataManager = [[AppDelegate alloc]init];
        _context = [coreDataManager managedObjectContext];
    }
    return _context;
}

- (NSArray *)queryData:(NSString *) entityname sortWith:(NSString *) sortDesc ascending:(BOOL) asc predicatString:(NSString *)ps{
    
    NSFetchRequest * request = [[NSFetchRequest alloc]init];
    request.fetchLimit = 100;
    request.fetchBatchSize = 20;
    request.sortDescriptors = @[[NSSortDescriptor sortDescriptorWithKey:sortDesc ascending:asc]];
    if(ps) request.predicate = [NSPredicate predicateWithFormat:@"name contains %@",ps];
    NSEntityDescription * entity = [NSEntityDescription entityForName:entityname inManagedObjectContext:self.context];
    request.entity = entity;
    NSError * error;
    NSArray * arrys = [self.context executeFetchRequest:request error:&error];
    if(error) NSLog(@"无法获取数据，%@",error);
    return arrys;
}

- (void)loadData{
    NSArray * arrstudents = [self queryData:@"Student" sortWith:@"number" ascending:YES predicatString:nil];
    _students = [NSMutableArray array];
    for(Student *stu in arrstudents){
        [_students addObject:stu];
        
        
    }
}

- (NSMutableArray *) students{
    if(!_students)[self loadData];
    return _students;
}

- (Teacher *) teacher{
    if(!_teacher){
        NSArray * arrteacher = [self queryData:@"Teacher" sortWith:@"name" ascending:YES predicatString:@"白天"];
        if(arrteacher.count>0)_teacher = arrteacher[0];
        else{
            NSError * error;
            Teacher * th = [NSEntityDescription insertNewObjectForEntityForName:@"Teacher" inManagedObjectContext:self.context];
            th.name = @"白天";
            th.age = 99;
            th.number = @"ST0002";
            [self.context save:&error];
            _teacher = th;
        }
        
    }
    return _teacher;
}




- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
  
}
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender{
    
    if([segue.identifier isEqualToString:@"addinfo"]){
        if([segue.destinationViewController isKindOfClass:[ViewController class] ]){
            ViewController * vc = (ViewController *)segue.destinationViewController;
            vc.students = self.students;
            vc.context = self.context;
            vc.indexPath = nil;
            vc.teacher = self.teacher;
            
        }
    }
    if([segue.identifier isEqualToString:@"showinfo"]){
        if([segue.destinationViewController isKindOfClass:[ViewController class] ]){
            NSIndexPath * indexPath = [self.tableView indexPathForCell:sender];
            ViewController * vc = (ViewController *)segue.destinationViewController;
            vc.students = self.students;
            vc.context = self.context;
            vc.indexPath = indexPath;
            vc.teacher = self.teacher;
            
            
        }
    }
    
}






#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
#warning Incomplete implementation, return the number of sections
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
#warning Incomplete implementation, return the number of rows
    return [self.students count];
}

-(UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    
    UITableViewCell * cell = [tableView dequeueReusableCellWithIdentifier:@"studentcell" forIndexPath:indexPath];
    self.student = self.students[indexPath.row];
    cell.textLabel.text = self.student.name;
    cell.detailTextLabel.text = self.student.number;
    return cell;
}
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath{
    if(editingStyle == UITableViewCellEditingStyleDelete){
        [self.context deleteObject:self.students[indexPath.row]];
        [self.students removeObjectAtIndex:indexPath.row];
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
        NSError * error;
        [self.context save:&error];
    }
    
}
- (void)tableView:(UITableView *)tableView accessoryButtonTappedForRowWithIndexPath:(NSIndexPath *)indexPath{
    ViewController *vc = [self.storyboard instantiateViewControllerWithIdentifier:@"modifyview"];
    vc.students = self.students;
    vc.indexPath = indexPath;
    vc.context = self.context;
    vc.teacher = self.teacher;
    [self.navigationController pushViewController:vc animated:YES];
}
- (IBAction)refreshData:(id)sender {
    [self.refreshControl beginRefreshing];
    //[self.tableView reloadData];
    dispatch_queue_t queue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0);
    dispatch_async(queue, ^{
        [self.students removeAllObjects];
        [self loadData];
        dispatch_async(dispatch_get_main_queue(), ^{[self.tableView reloadData];});
    });
 
    [self.refreshControl endRefreshing];
}

#pragma mark - searchbar

- (void)searchInName:(NSString *)searchString{
    [self.students removeAllObjects];
    NSArray * arrstudents = [self queryData:@"Student" sortWith:@"number" ascending:YES predicatString:searchString];
    for(Student * stu in arrstudents){
        [self.students addObject:stu];
    }
    [self.tableView reloadData];
}
- (void) searchBar:(UISearchBar *)searchBar textDidChange:(NSString *)searchText{
    if(searchText.length == 0){
        //return修改一下
        dispatch_queue_t queue = dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0);
        dispatch_async(queue, ^{
            [self.students removeAllObjects];
            [self loadData];
            dispatch_async(dispatch_get_main_queue(), ^{[self.tableView reloadData];});
        });
    }
    [self searchInName:searchText];
}
- (void)searchBarSearchButtonClicked:(UISearchBar *)searchBar{
    
    [self searchInName:searchBar.text];
    [searchBar resignFirstResponder];
}

- (void)searchBarCancelButtonClicked:(UISearchBar *)searchBar{
    [self searchInName:nil];
    [searchBar resignFirstResponder];
    [self.tableView reloadData];
}
    
    








/*
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:<#@"reuseIdentifier"#> forIndexPath:indexPath];
    
    // Configure the cell...
    
    return cell;
}
*/

/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
