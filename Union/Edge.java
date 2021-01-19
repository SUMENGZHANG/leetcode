/**
 *  两点之间的曼哈顿距离生成边
 */
public class Edge implements Comparable {
    private int x;
    private int y;
    private int len;

    public Edge(int x, int y,int len){
        this.x = x;
        this.y = y;
        this.len = len;
    }
    
    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public void setLen(int len){
        this.len = len;
    }

    public int getLen(){
        return len;
    }

    @Override
    public b compareTo(Edge o){
        return Integer.compare(this.len,o.len);
    }

    
}
