/*
 * mxhsd - Corporate Matrix Homeserver
 * Copyright (C) 2017 Maxime Dor
 *
 * https://www.kamax.io/
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.mxhsd.api.room.event;

import com.google.gson.JsonObject;
import io.kamax.mxhsd.GsonUtil;
import io.kamax.mxhsd.api.room.RoomEventType;
import io.kamax.mxhsd.core.event.NakedContentEvent;
import io.kamax.mxhsd.core.room.RoomPowerLevels;

public class RoomPowerLevelEvent extends NakedContentEvent {

    public RoomPowerLevelEvent get(JsonObject o) {
        RoomPowerLevelEvent e = new RoomPowerLevelEvent(o);
        if (!RoomEventType.PowerLevels.is(e.getType())) {
            throw new IllegalArgumentException("Expected event JSON with type " + RoomEventType.PowerLevels.get() + " but got " + e.getType());
        }
        return e;
    }

    private String stateKey = "";

    private RoomPowerLevelEvent(JsonObject o) {
        super(o);
    }

    public RoomPowerLevelEvent(String sender, RoomPowerLevels pls) {
        super(RoomEventType.PowerLevels.get(), sender, GsonUtil.makeObj(pls));
    }

}
