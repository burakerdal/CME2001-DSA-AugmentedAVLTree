package assignment2;

import static assignment2.TestAVL.augavlt;



public class AugmentedAVLNode
{    
    public AugmentedAVLNode left, right,parent;
    public int data;
    public int key;
    public int height;
    
    

	public AugmentedAVLNode()
    {
        left = null;
        right = null;
        parent = null;
        data = 0;
        key=0;
        height = 0;
    }

    public AugmentedAVLNode(int n)
    {
        left = null;
        right = null;
        parent = null;
        data = n;
        key=getKey(n);
        height = 0;
    }
    
    public int getKey(int data) {
		return augavlt.gss(data);
	}
    
    public void setKey(int key) {
		this.key = key;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	
}
