仿小米社区 App 底部导航栏以及TAB切换动画

底部导航栏使用继承自 LinearLayout 的 BottomNaviBox 作为 TAB 的容器。每个 TAB 对应着一个 BottomNaviView。

BottomNaviView 使用 2 个 ImageView 和 2 个 TextView 展示图片和文字的二态，通过 ViewPager.OnPageChangeListener 的 onPageScrolled 函数改变透明度实现动画效果。