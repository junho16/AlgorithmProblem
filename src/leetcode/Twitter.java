package leetcode;

import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 *
 * 实现 Twitter 类：
 *
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近  10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 *
 * @author Junho
 * @date 2022/4/9 22:06
 */
public class Twitter {
    class TwitterNode{
        int time;
        int tweetId;
        public TwitterNode(int id , int time){
            this.tweetId = id;
            this.time = time;
        }
    }

    int timeIdx;

    //用户和其关注的列表
    Map<Integer , Set<Integer>> follorMap;

    //用户的推特列表
    Map<Integer , List<TwitterNode>> twitterNodeMap;

    public Twitter() {
        timeIdx = 0;
        follorMap = new HashMap<>();
        twitterNodeMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        System.out.println(  " postTweet ==> " );
        if(! twitterNodeMap.containsKey(userId)){
            twitterNodeMap.put(userId , new ArrayList<>());
        }
        twitterNodeMap.get(userId).add(new TwitterNode(tweetId , timeIdx++));

        for(Integer i: twitterNodeMap.keySet()){
            System.out.print( i+" ==> " );
            for(TwitterNode j : twitterNodeMap.get(i)){
                System.out.print(j.tweetId+"/"+j.time+" ");
            }
        }
        System.out.println();
    }

    public List<Integer> getNewsFeed(int userId) {
        System.out.println(  " getNewsFeed ==> " );
        Set<Integer> userList = follorMap.get(userId);
        List<Integer> res = new ArrayList<>();
        List<TwitterNode> resWithNode = new ArrayList<>();
        if(twitterNodeMap.containsKey(userId))
            resWithNode.addAll(twitterNodeMap.get(userId));
        if(userList != null)
            for(Integer user : userList){
                if(twitterNodeMap.containsKey(user))
                    resWithNode.addAll(twitterNodeMap.get(user));
            }

        Collections.sort(resWithNode, new Comparator<TwitterNode>() {
            @Override
            public int compare(TwitterNode o1, TwitterNode o2) {
                return o2.time - o1.time;
            }
        });

        for(TwitterNode twitterNode : resWithNode){
            System.out.println(twitterNode.tweetId +" " + twitterNode.time);

            res.add(twitterNode.tweetId);
            if(res.size() == 10)
                break;
        }
        System.out.println("===");
        return res;
    }

    public void follow(int followerId, int followeeId) {
        System.out.println(  " follow ==> " );
//        ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
        if(! follorMap.containsKey(followerId)){
            follorMap.put(followerId , new HashSet<>());
        }
        follorMap.get(followerId).add(followeeId);

        for(Integer i: follorMap.keySet()){
            System.out.print( i+" ==> " );
            for(Integer j : follorMap.get(i)){
                System.out.print(j+" ");
            }
        }
        System.out.println();
    }

    public void unfollow(int followerId, int followeeId) {
        if(follorMap.containsKey(followerId))
            follorMap.get(followerId).remove(new Integer(followeeId));
        System.out.println(  " unfollow ==> " );
        for(Integer i: follorMap.keySet()){
            System.out.print( i+" ==> " );
            for(Integer j : follorMap.get(i)){
                System.out.print(j+" ");
            }
        }
        System.out.println();
    }


}
