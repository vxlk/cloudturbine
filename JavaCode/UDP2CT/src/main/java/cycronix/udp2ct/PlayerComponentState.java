/*
Copyright 2018 Erigo Technologies

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/*

PlayerComponentState

A class representing one component of a game player's world.

John Wilson, Erigo Technologies

version: 2018-10-24

*/

package cycronix.udp2ct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerComponentState {

    private String id;
    private String model;
    // state will always be true; not including this field will default it to true
    // private boolean state = true;
    private List<Double> pos;
    private List<Double> rot;

    // Can initialize scale to be the 3-element array Arrays.asList(0.0, 0.0, 0.0),
    // which should be interpreted to mean "no change to the native scale";
    // however, scale is an optional field, so leaving it out will be interpreted
    // the same way and it doesn't "puff" out the JSON packet with unnecessary fields.
    private List<Double> scale;

    // link is an optional field which we don't use
    // private String link;

    // Can initialize color to be the 4-element array Arrays.asList(0.0, 0.0, 0.0, 0.0),
    // which should be interpreted to mean "use the native object color";
    // however, color is an optional field, so leaving it out will be interpreted
    // the same way and it doesn't "puff" out the JSON packet with unnecessary fields.
    private List<Double> color;

    public PlayerComponentState(String idI, String modelI, boolean stateI, double xI, double altI, double yI, double pitchI, double headingI, double rollI, String urlI) {
        id = idI;
        model = modelI;
        // state will always be true; not including this field will default it to true
        // state = stateI;
        pos = new ArrayList<Double>();
        pos.add(LimitPrecision(xI));
        pos.add(LimitPrecision(altI));
        pos.add(LimitPrecision(yI));
        rot = new ArrayList<Double>();
        rot.add(LimitPrecision(pitchI));
        rot.add(LimitPrecision(headingI));
        rot.add(LimitPrecision(rollI));
        // link is an optional field which we don't use
        // link = urlI;
    }

    /// <summary>
    /// Limit the precision of a given floating point value.
    /// </summary>
    /// <param name="valI">Input floating point value.</param>
    /// <returns>The double with the desired number of decimal places of precision.</returns>
    public static double LimitPrecision(double valI)
    {
        // Desired number of decimal places of precision.
        int prec = 5;
        return ((long)(valI * Math.pow(10.0, prec))) / Math.pow(10.0, prec);
    }

}
