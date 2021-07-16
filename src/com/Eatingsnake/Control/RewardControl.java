package com.Eatingsnake.Control;

import com.Eatingsnake.Reward;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class RewardControl {

    Logger logger = Logger.getLogger("snake");

    List<Reward> rewardList = new ArrayList<>();

    public RewardControl() {
    }

    public void remove(Reward rr){
        synchronized (rewardList) {
            if (rewardList.contains(rr)) {
                Boolean res = rewardList.remove(rr);
                logger.info("the reward is removed...");
            }
            logger.info("the reward is not exist in the list");
            return;
        }
    }

    public void generate(int xLimit, int yLimit){
        synchronized (rewardList) {
            Random random = new Random();
            int x = random.nextInt(xLimit);
            int y = random.nextInt(yLimit);
            int count = random.nextInt(2);
            Reward reward = new Reward(x, y, count);
            rewardList.add(reward);
        }
    }


}
