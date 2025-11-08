import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Main {
    // -----------------------------------------------------------
    // 1. ISOLATED calculateIntegrity FUNCTION (Pasted from original file)
    // -----------------------------------------------------------
	private static int[] calculateIntegrity(Map<String, String> mp) {
		int result = 0;
		int result_bicycle_routing = 0;
		String surface = mp.get("surface");
		String smoothness = mp.get("smoothness");
		String tracktype = mp.get("tracktype");
		String highway = mp.get("highway");
		String bicycle = mp.get("bicycle");
		String foot = mp.get("foot");
		if (surface != null) {
			surface = surface.toLowerCase();
		}
		if (smoothness != null) {
			smoothness = smoothness.toLowerCase();
		}
		if (tracktype != null) {
			tracktype = tracktype.toLowerCase();
		}
		if ("paved".equals(surface) || "concrete".equals(surface) || "concrete:lanes".equals(surface)
				|| "concrete:plates".equals(surface) || "sett".equals(surface) || "paving_stones".equals(surface)
				|| "metal".equals(surface) || "wood".equals(surface) || "chipseal".equals(surface)) {
			result += 3;
			result_bicycle_routing += 3;
		} else if ("fine_gravel".equals(surface) || "grass_paver".equals(surface)) {
			result += 4;
			result_bicycle_routing += 4;
		} else if ("compacted".equals(surface)) {
			result += 8;
			result_bicycle_routing += 8;
		} else if ("cobblestone".equals(surface)) {
			result += 8;
			result_bicycle_routing += 8;
		} else if ("pebblestone".equals(surface)) {
			result += 9;
			result_bicycle_routing += 9;
		} else if ("ground".equals(surface) || "earth".equals(surface) || "dirt".equals(surface)) {
			result += 9;
			result_bicycle_routing += 9;
		} else if ("grass".equals(surface)) {
			result += 12;
			result_bicycle_routing += 12;
		} else if ("gravel".equals(surface)) {
			result += 12;
			result_bicycle_routing += 12;
		} else if ("stone".equals(surface) || "rock".equals(surface) || "rocky".equals(surface)) {
			result += 13;
			result_bicycle_routing += 13;
		} else if ("unpaved".equals(surface)) {
			result += 14;
			result_bicycle_routing += 14;
		} else if ("salt".equals(surface) || "ice".equals(surface) || "snow".equals(surface)) {
			result += 15;
			result_bicycle_routing += 15;
		} else if ("sand".equals(surface)) {
			result += 16;
			result_bicycle_routing += 16;
		} else if ("mud".equals(surface)) {
			result += 18;
			result_bicycle_routing += 18;
		}
		if ("excellent".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 7;
				result_bicycle_routing = 6;
			} else {
				result -= 5;
				result_bicycle_routing -= 5;
			}
		} else if ("very_good".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 6;
				result_bicycle_routing = 6;
			} else {
				result -= 4;
				result_bicycle_routing -= 6;
			}
		} else if ("good".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 8;
				result_bicycle_routing = 6;
			} else {
				result -= 2;
				result_bicycle_routing -= 2;
			}
		} else if ("intermediate".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 9;
				result_bicycle_routing = 9;
			}
		} else if ("bad".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 9;
				result_bicycle_routing = 9;
			} else if ("asphalt".equals(surface)) {
				result += 7;
				result_bicycle_routing += 7;
			} else {
				result += 6;
				result_bicycle_routing += 6;
			}
		} else if ("very_bad".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 12;
				result_bicycle_routing = 12;
			} else if ("asphalt".equals(surface)) {
				result += 12;
				result_bicycle_routing += 12;
			} else {
				result += 7;
				result_bicycle_routing += 7;
			}
		} else if ("horrible".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 15;
				result_bicycle_routing = 15;
			} else if ("asphalt".equals(surface)) {
				result += 19;
				result_bicycle_routing += 19;
			} else {
				result += 9;
				result_bicycle_routing += 9;
			}
		} else if ("very_horrible".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 18;
				result_bicycle_routing = 18;
			} else if ("asphalt".equals(surface)) {
				result += 22;
				result_bicycle_routing += 22;
			} else {
				result += 11;
				result_bicycle_routing += 11;
			}
		} else if ("impassable".equals(smoothness)) {
			if (("track".equals(highway) || ("path".equals(highway))) && (surface == null)) {
				result = 24;
				result_bicycle_routing = 24;
			} else if ("asphalt".equals(surface)) {
				result += 26;
				result_bicycle_routing += 26;
			} else {
				result += 12;
				result_bicycle_routing += 12;
			}
		}
		if (surface == null) {
			if ("grade1".equals(tracktype)) {
				result += 1;
				result_bicycle_routing += 6;
			} else if ("grade2".equals(tracktype)) {
				result += 3;
				result_bicycle_routing += 9;
			} else if ("grade3".equals(tracktype)) {
				result += 7;
				result_bicycle_routing += 9;
			} else if ("grade4".equals(tracktype)) {
				result += 10;
				result_bicycle_routing += 12;
			} else if ("grade5".equals(tracktype)) {
				result += 15;
				result_bicycle_routing += 16;
			}
		}
		if (("motorway".equals(highway) || ("motorway_link".equals(highway)) || ("trunk".equals(highway))
				|| ("trunk_link".equals(highway)) || ("primary".equals(highway)) || ("primary_link".equals(highway))
				|| ("secondary".equals(highway)) || ("secondary_link".equals(highway)) || ("tertiary".equals(highway))
				|| ("tertiary_link".equals(highway)) || ("unclassified".equals(highway))
				|| ("residential".equals(highway)) || ("service".equals(highway)) || ("pedestrian".equals(highway))
				|| ("living_street".equals(highway)) || ("footway".equals(highway)) || ("cycleway".equals(highway)))
				&& (surface == null) && (smoothness == null)) {
			result = 100;
		}
		if (("track".equals(highway) || "path".equals(highway))
				&& ((surface == null) && (smoothness == null) && (tracktype == null))) {
			result = 100;
		}
		if ("track".equals(highway) && (surface == null) && (smoothness == null) && (tracktype == null)) {
			result_bicycle_routing = 9;
		}
		if (("path".equals(highway) && (surface == null) && (smoothness == null) && (tracktype == null))) {
			result_bicycle_routing = 12;
		}
		if (("footway".equals(highway) && (surface == null) && (smoothness == null) && (tracktype == null))) {
			result_bicycle_routing = 6;
		}
		if ("path".equals(highway)) {
			if ("designated".equals(bicycle)) {
				result = 0;
				result_bicycle_routing = 0;
			} else if ("designated".equals(foot)) {
				result = 2;
			}
		}
		if (result < 0) {
			result = 0;
		}
		int[] result_array = { result, result_bicycle_routing };
		return result_array;
	}
    
    // -----------------------------------------------------------
    // 2. MAIN METHOD TO TEST THE ISOLATED FUNCTION
    // -----------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- Integrity Function Test Harness ---");
        
        // Test 1
        Map<String, String> test1 = new HashMap<>();
        test1.put("highway", "tertiary");
        test1.put("surface", "dirt");
        test1.put("smoothness", "bad");
        
        int[] scores1 = calculateIntegrity(test1);
        int normalized1 = scores1[0] / 3;
        
        System.out.println("\nTest 1: Raw=" + scores1[0] + ", Normalized=" + normalized1);

        // Test 2
        Map<String, String> test2 = new HashMap<>();
        test2.put("highway", "primary");
        // surface = null, smoothness = null
        
        int[] scores2 = calculateIntegrity(test2);
        int normalized2 = scores2[0] / 3;
        
        System.out.println("Test 2: Raw=" + scores2[0] + ", Normalized=" + normalized2);
    }
}