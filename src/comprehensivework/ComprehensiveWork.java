package comprehensivework;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.*;
import java.awt.event.*;
class Sort_Search {
    Integer[] num = { 21, 7, 19, 102, 23, 30, 4, 57, 15, 10 };
    String s;
    ArrayList list = new ArrayList();
    public void sortDirection( String s ){  //确定排序方向是从小到大还是从大到小
        if( s.equals( "升序" ) ){
            Arrays.sort( num );
            System.out.println( "从小到大排序如下：" );
            for( int j = 0; j < num.length; j ++ ){
                System.out.print( num[ j ] + " " );
            }
            System.out.println();
        }
        else if( s.equals( "降序" ) ){
            Arrays.sort( num, Collections.reverseOrder() );  //逆序
            System.out.println( "从大到小排序如下;" );
            for( int j = 0; j < num.length; j ++ ){
                System.out.print( num[ j ] + " " );
            }
            System.out.println();
        }
    }
    public void selectSort(){  //选择排序
        if( s.equals( "升序" ) ){
            for( int i = 0; i < num.length - 1; i ++ ){
                int k = i;
                for( int j = i + 1; j < num.length; j ++ ){
                    if( num[j] < num[k] ){
                        k = j;    //记录下最小下标
                    }
                }
                if( k != i ){
                    int temp = num[i];
                    num[i] = num[k];
                    num[k] = temp;
                }
            }
        }
        else if( s.equals( "降序" ) ){
            for( int i = 0; i < num.length; i ++ ){
                num[i] = - num[i];
            }
            for( int i = 0; i < num.length - 1; i ++ ){
                int k = i;
                for( int j = i + 1; j < num.length; j ++ ){
                    if( num[j] < num[k] ){
                        k = j;    //记录下最小下标
                    }
                }
                if( k != i ){
                    int temp = num[i];
                    num[i] = num[k];
                    num[k] = temp;
                }
            }
            for( int i = 0; i < num.length; i ++ ){
                num[i] = - num[i];
            }
        }
    }
    public void bubbleSort(){  //冒泡排序
        int temp;
        if( s.equals( "升序" ) ){
            for( int i = 0; i < num.length - 1; i ++ ){
                for( int j = 0; j < num.length - 1 - i; j ++ ){
                    if( num[j+1] < num[j] ){  //交换位置，下标小的存放小的数字
                        temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                    }
                }
            }
        }
        else if( s.equals( "降序" ) ){
            for( int i = 0; i < num.length; i ++ ){
                num[i] = - num[i];
            }
            for( int i = 0; i < num.length - 1; i ++ ){
                for( int j = 0; j < num.length - 1 - i; j ++ ){
                    if( num[j+1] < num[j] ){  //交换位置，下标小的存放小的数字
                        temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                    }
                }
            }
            for( int i = 0; i < num.length; i ++ ){
                num[i] = - num[i];
            }
        }
    }
    public void insertSort( int key ){  //插入排序
        list = new ArrayList();   //每次调用都重新初始化防止list中保存输出之前排序结果
        selectSort();  //调用选择排序先将数组内的数据从小到大排好序
        for( int i = 0; i < num.length; i ++ ){   //将用选择排序排好序的数组拷贝到新建的可动态扩容的数组中去
            list.add( num[i] );
        }
        int m;  //当前值的位置
            if( s.equals( "降序" ) ){
                for( m = 0; m < list.size(); m ++ ){
                    if( ( int )list.get( m ) < key ){
                        list.add( m, key );
                        break;
                    }
                }
            }
            else{
                for( m = 0; m < list.size(); m ++ ){
                    if( ( int )list.get( m ) > key ){
                        list.add( m, key );
                        break;
                    }
                }
            } 
    }
    public int binarySearch( int searchnum ){   //二分查找
        bubbleSort();   //冒泡排序把数组中数据从小到大排序
        int low = 0;
        int high = list.size() - 1;
        int index = -1;
        int middle;
        while( low <= high && s.equals( "升序" ) ){
            middle = ( high - low ) / 2 + low;
            if( searchnum == ( int )list.get( middle ) ){
                index = middle;
                break;
            }
            else if( searchnum < ( int )list.get( middle ) ){
                high = middle - 1;
            }
            else{
                low = middle + 1;
            }
        }
        while( low <= high && s.equals( "降序" ) ){
            middle = ( high - low ) / 2 + low;
            if( searchnum == ( int )list.get( middle ) ){
                index = middle;
                break;
            }
            else if( searchnum > ( int )list.get( middle ) ){
                high = middle - 1;
            }
            else{
                low = middle + 1;
            }
        }
        if( index == -1 ){
            return -1;
        }
        else{
            return index;
        }
    }
    public String toString( Integer[] shuzu ){  //输出数组
        return Arrays.toString( shuzu );
    }
    public Integer[] printData(){   //将list终的数据存放在Integer数组中以便调用toString()函数输出
        int n = list.size();
        Integer[] data = new Integer[ n ];
        for( int i = 0; i < n; i ++ ){
            data[i] = Integer.valueOf(list.get( i ).toString() );
        }
        return data;
    }
}
class GUI extends JFrame{
    Sort_Search ss = new Sort_Search();
    JTextArea area = new JTextArea();
    JMenuBar menuBar = new JMenuBar();  //创建一组下拉菜单，JMenu的容器
    JMenu menu = new JMenu();
    JMenuItem item_1 = new JMenuItem();  //创建菜单中的选项
    JMenuItem item_2 = new JMenuItem();
    JMenuItem item_3 = new JMenuItem();
    JMenuItem item_4 = new JMenuItem();
    JMenuItem item_5 = new JMenuItem();
    public GUI(){
        getContentPane().add( new JScrollPane( area ) );
        item_1.setText( "排序方向" );
        item_2.setText( "选择排序" );
        item_3.setText( "冒泡排序" );
        item_4.setText( "插入排序" );
        item_5.setText( "退出" );
        menu.setText( "菜单" );
        JButton b = new JButton( "二分查找" );
        setJMenuBar( menuBar );
        menuBar.add( menu );
        item_1.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                ss.s = JOptionPane.showInputDialog( null, "请输入排序方向（升序/降序）：\n", "排序方向", JOptionPane.PLAIN_MESSAGE );
                area.append( "排序方向为：" + ss.s + "\n" + "\n" );
            }
        });
        menu.add( item_1 );
        item_2.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                ss.selectSort();
                area.append( "按照  选择排序  的方法  " + ss.s + "  排序后结果如下：\n" + ss.toString( ss.num ) + "\n" + "\n" );
            }
        });
        menu.add( item_2 );
        item_3.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                ss.bubbleSort();
                area.append( "按照  冒泡排序  的方法  " + ss.s + "  排序后结果如下：\n" + ss.toString( ss.num ) + "\n" + "\n" );
            }
        });
        menu.add( item_3 );
        item_4.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                int num = Integer.parseInt( JOptionPane.showInputDialog( null, "请输入要插入的数：", "插入排序", JOptionPane.PLAIN_MESSAGE ) );
                ss.insertSort( num );
                area.append( "插入" + num + "后的数组展示如下：" + "\n" + ss.toString( ( ss.printData() ) ) + "\n" + "\n" );
            }
        });
        menu.add( item_4 );
        menu.addSeparator();
        item_5.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                System.exit( 0 );
            }
        });
        menu.add( item_5 );
        b.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent e ){
                int number;
                number = Integer.parseInt( JOptionPane.showInputDialog( null, "请输入要查找的数：\n", "二分查找", JOptionPane.PLAIN_MESSAGE ) );
                if( ss.binarySearch( number ) == -1 ){
                    JOptionPane.showConfirmDialog( null, "此数不存在！", "二分查找", JOptionPane.PLAIN_MESSAGE );
                }
                else{
                    String str = number + "在数组中的位置为" + ss.binarySearch( number );
                    JOptionPane.showConfirmDialog( null, str, "二分查找", JOptionPane.PLAIN_MESSAGE );
                }
            }
        });
        menuBar.add( b );
        this.setTitle( "综合作业" );
        this.setSize( 300, 300 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}
public class ComprehensiveWork {   
    public static void main(String[] args) {
        GUI gui = new GUI();
    }   
}