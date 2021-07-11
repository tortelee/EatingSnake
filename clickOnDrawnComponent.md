https://stackoverflow.com/questions/12933592/clicking-on-a-drawn-object#

I've got a class called Shape which inherits from JPanel.

A number of sub-classes in turn extend the Shape classes, one for each type of shape.

Each shape has its own overriden paint() method, which draws the respective shape.

I would like to be able to click on any shape, and am trying to implement this logic for now. Please note that each shape has been added to an arrayList.

However, the contains statement always returns false, even when I have clearly clicked inside the shape.

Any ideas?

### 游戏的规则
游戏的规则 是一个单独的概念。
设计到控制，主要是检测头部，
- 头部是否撞边界
- 头部是否吃到奖励
- 头部是否碰到自身

是在一层实行这种判断呢？
- UI 层
- 鼠标控制层
- 单独的层？

表现层与逻辑层，逻辑层最终决定是什么样子，然后传给表现层。
其中用户 也可以从表现层输入，这个另外一个逻辑了。

###### 总结一下
- 表现层，UI层  一个继承Jframe的类 Jframe(-->Control(snake),Mouse)
    - 画背景
    - 按钮组件: 开始，暂停，退出
    - 画蛇。蛇的信息是由snake对象保存的，包括运动的方向。
    需要由逻辑层将这个蛇对象引用，搞过去
      
- 蛇 Snake
    - 更新蛇的位置和方向
    - 更新蛇的大小
    
- 输入方面Mouse(Control,(snake)) 只是传递过去事件
    - 鼠标移动，交互的对象是event
    - 键盘输入，传递对象是event
    
- 逻辑控制层 Control（JFrame,Snake）
    - 每秒自动移动
    - 撞墙
    - 撞自身身体
    - 吃到奖励
    - 输入控制（传递什么呢？1，通知对象，2，把接收到的信息传下去）
        - 传递鼠标信息
        - 传递键盘信息
  

    

### Referenece
##### frame
[official doc](https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html)

A Frame is a top-level window with a title and a border

[charBarClick](https://stackoverflow.com/questions/28899094/java-swing-clickable-jfree-charts-clicked-each-bar-chart-or-pie-chart-to-open-n)

ou need to add a ChartMouseListener to your chartPanel.
```java
chartPanel.addChartMouseListener(new ChartMouseListener() {

    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
        ChartEntity entity = event.getEntity();
        System.out.println(entity);
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent event) {
    }
});
```
The ChartEntity will be a CategoryItemEntity that you can use to access the rowKey, columnKey and dataset. 
Then you can open a a dialog or tab to display the data found.

[How to write painting code in Java](http://java.sun.com/products/jfc/tsc/articles/painting/index.html)

[frame.add() VS panel.add()](https://stackoverflow.com/questions/10086936/java-adding-components-to-jframe)

##### class.newInstance 生成对象与多态
希望通过class生成对象，且对象的类型随着动态运行时决定
```java
            Class c =  position.get(0).getClass();
            try {
                ShapeofSnake shapeofSnake = (ShapeofSnake) c.newInstance();
                shapeofSnake.draw(Graphics.class.newInstance());
                shapeofSnake.setPoint1_x(x1);
```

这种写法可能吗？
