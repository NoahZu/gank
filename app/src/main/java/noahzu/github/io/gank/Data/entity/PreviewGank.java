package noahzu.github.io.gank.Data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class PreviewGank {

    // 获取img标签正则
    private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
    // 获取src路径的正则
    private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";

    public String _id;// "577c8563421aa964a66e58b7",
    public String content;// "<p><img alt="" src="http://ww2.sinaimg.cn/large/610dc034jw1f5k1k4azguj20u00u0421.jpg" /></p> <h3>iOS</h3> <ul> <li><a href="https://github.com/nixzhu/dev-blog/blob/master/2016-06-29-coolie.md" target="_blank">将一个 JSON 文件&ldquo;编译&rdquo;为一个 Swift 文件</a>&nbsp;(tripleCC) <ul> </ul> </li> <li><a href="http://mp.weixin.qq.com/s?__biz=MjM5NTIyNTUyMQ==&amp;mid=2709545008&amp;idx=1&amp;sn=c0dc147e9d947688f2a833ed200dac2d&amp;scene=0#wechat_redirect" target="_blank">Objective-C Fast Enumeration 的实现原理</a>&nbsp;(tripleCC) <ul> </ul> </li> <li><a href="http://xn--rgvu79ah1g.com/ios%E4%B9%8B%E8%B7%AF/iOS-Android-Server-Emoji" target="_blank">iOS Emoji 表情踩过的坑，走过的弯路</a>&nbsp;(代码家) <ul> <li><a href="http://xn--rgvu79ah1g.com/ios%E4%B9%8B%E8%B7%AF/iOS-Android-Server-Emoji" target="_blank"><img src="http://xn--rgvu79ah1g.com/images/ios_andorid_server_emoji/5.png" title="iOS Emoji 表情踩过的坑，走过的弯路" /></a></li> </ul> </li> <li><a href="https://github.com/Draveness/DKChainableAnimationKit" target="_blank">Swift 链式调用动画库，做的棒棒的。</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/Draveness/DKChainableAnimationKit" target="_blank"><img src="https://github.com/Draveness/DKChainableAnimationKit/raw/master/Gifs/Code2.png" title="Swift 链式调用动画库，做的棒棒的。" /></a></li> <li><a href="https://github.com/Draveness/DKChainableAnimationKit" target="_blank"><img src="https://github.com/Draveness/DKChainableAnimationKit/raw/master/Gifs/Demo2.gif" title="Swift 链式调用动画库，做的棒棒的。" /></a></li> </ul> </li> <li><a href="https://github.com/danthorpe/Money" target="_blank">自动帮你做货币转换的工具库，相当实用</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/danthorpe/Money" target="_blank"><img src="https://raw.githubusercontent.com/danthorpe/Money/development/header.png" title="自动帮你做货币转换的工具库，相当实用" /></a></li> </ul> </li> <li><a href="https://github.com/KittenYang/GooeyTabbar" target="_blank">粘性 Tabbar 效果，可以看代码学习如何做类似效果</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/KittenYang/GooeyTabbar" target="_blank"><img src="https://github.com/KittenYang/GooeyTabbar/raw/master/gooeyTabbar_Temple.gif" title="粘性 Tabbar 效果，可以看代码学习如何做类似效果" /></a></li> </ul> </li> </ul> <h3>Android</h3> <ul> <li><a href="https://github.com/skyfe79/AndroidGradientImageView" target="_blank">Android 色彩渐进 ImageView</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/skyfe79/AndroidGradientImageView" target="_blank"><img src="https://github.com/skyfe79/AndroidGradientImageView/raw/master/art/gradient-animation.gif" title="Android 色彩渐进 ImageView" /></a></li> </ul> </li> <li><a href="https://github.com/yarolegovich/LovelyDialog" target="_blank">Android 上漂亮的 Dialog 效果</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/yarolegovich/LovelyDialog" target="_blank"><img src="https://raw.githubusercontent.com/yarolegovich/lovelydialog/master/art/lovelydialogs_framed.png" title="Android 上漂亮的 Dialog 效果" /></a></li> </ul> </li> <li><a href="https://github.com/code-crusher/Image-Zoomer" target="_blank">Android 图片点击全屏放大效果</a>&nbsp;(代码家) <ul> <li><a href="https://github.com/code-crusher/Image-Zoomer" target="_blank"><img src="https://github.com/code-crusher/Image-Zoomer/raw/master/screenshots/zoom.gif" title="Android 图片点击全屏放大效果" /></a></li> </ul> </li> <li><a href="https://github.com/frogermcs/LikeAnimation.git" target="_blank">twitter 点赞效果&nbsp;</a>(lizhuo) <ul> </ul> </li> <li><a href="https://github.com/barryhappy/TEmptyView" target="_blank">TEmptyView是一个小轮子，希望能够更简单地设置EmptyView，免除每次设置emptyView都要写xml之苦。 支持AdapterView(ListView/GridView等)、RecyclerView。</a>&nbsp;(Barry) <ul> </ul> </li> </ul> <h3>瞎推荐</h3> <ul> <li><a href="http://steachs.com/archives/19307" target="_blank">Panel Tabs - 把任何一个网页变成浮动视窗，真正独立一个画面</a>&nbsp;(lxxself) <ul> </ul> </li> </ul> <h3>App</h3> <ul> <li><a href="https://github.com/fabiomsr/MoneyTextView" target="_blank">A simple Android TextView to display amounts of money in different formats.</a>&nbsp;(咕咚) <ul> <li><a href="https://github.com/fabiomsr/MoneyTextView" target="_blank"><img src="https://raw.githubusercontent.com/fabiomsr/MoneyTextView/develop/art/screenshot1.png" title="A simple Android TextView to display amounts of money in different formats." /></a></li> </ul> </li> </ul> <h3>休息视频</h3> <ul> <li><a href="http://www.bilibili.com/video/av5205871/" target="_blank">8分钟看完权力的游戏第六季（强力剧透）</a>&nbsp;(代码家) <ul> </ul> </li> </ul> <p><iframe frameborder="0" height="498" src="http://player.youku.com/embed/XMTYzMTk4MjI2MA==" width="510"></iframe></p> <p>感谢所有默默付出的编辑们，愿大家有美好一天。</p> ",
    public String publishedAt;// "2016-07-06T12:12:00.0Z",
    public String title;// "8分钟看完权力的游戏第六季（强力剧透）"


    public String getImageUrl(){
        return getImageSrc(getImageUrl(content)).get(0);
    }

    /***
     * 获取ImageUrl地址
     *
     * @param HTML
     * @return
     */
    private List<String> getImageUrl(String HTML) {
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
        List<String> listImgUrl = new ArrayList<String>();
        while (matcher.find()) {
            listImgUrl.add(matcher.group());
        }
        return listImgUrl;
    }

    /***
     * 获取ImageSrc地址
     *
     * @param listImageUrl
     * @return
     */
    private List<String> getImageSrc(List<String> listImageUrl) {
        List<String> listImgSrc = new ArrayList<String>();
        for (String image : listImageUrl) {
            Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
            while (matcher.find()) {
                listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
            }
        }
        return listImgSrc;
    }
}
