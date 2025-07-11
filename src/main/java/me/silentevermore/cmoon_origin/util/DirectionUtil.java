package me.silentevermore.cmoon_origin.util;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

public class DirectionUtil {
    public static Direction toDirection(Vec3d vec){
        double absX=Math.abs(vec.x);
        double absY=Math.abs(vec.y);
        double absZ=Math.abs(vec.z);
        if (absX>=absY && absX>=absZ) {
            return vec.x>0 ? Direction.EAST : Direction.WEST;
        }else if (absY>=absX && absY>=absZ) {
            return vec.y>0 ? Direction.UP : Direction.DOWN;
        }else{
            return vec.z>0 ? Direction.SOUTH : Direction.NORTH;
        }
    }
}
