public class q2 {

  public static void main(String[] args) {
    char[][] grid = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };
    int res = numIslands(grid);
    System.out.println(res);
  }

  public static int numIslands(char[][] grid) {
    int m=grid.length;
    int n=grid[0].length;
    int res=0;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        //if grid[i][j] == 1, it means we have find a start point of a new island
        if(grid[i][j]=='1'){
          findIslands(grid,i,j);
          //finish finding the island,increase the number of island
          res++;
        }
      }
    }
    return res;
  }
  public static void findIslands(char[][] grid,int i,int j){
    //we have exceed the boundary of the grid or this position we have met before
    if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'||grid[i][j]=='#'){
      return;
    }
    //mark current position as visited
    grid[i][j]='#';
    //search four directions
    findIslands(grid,i+1,j);
    findIslands(grid,i-1,j);
    findIslands(grid,i,j+1);
    findIslands(grid,i,j-1);
  }

}
