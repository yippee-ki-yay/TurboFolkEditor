package serialization;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableStrokeAdapter implements Stroke, Serializable
{
	private static final long serialVersionUID = -7383934174144921157L;

	Stroke s;
	
	public SerializableStrokeAdapter(Stroke s)
	{
		this.s = s;
	}
	
	
	private void writeObject(ObjectOutputStream o) throws IOException
	{
		if (s instanceof BasicStroke) 
		{
			BasicStroke stroke = (BasicStroke) s;
			o.writeFloat(stroke.getLineWidth());
			o.writeInt(stroke.getEndCap());
			o.writeInt(stroke.getLineJoin());
			o.writeFloat(stroke.getMiterLimit());
			o.writeObject(stroke.getDashArray());
			o.writeFloat(stroke.getDashPhase());
		}
		
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		s = new BasicStroke(in.readFloat(), in.readInt(), in.readInt(),
				in.readFloat(), (float[])in.readObject(), in.readFloat());
	}
	
	@Override
	public Shape createStrokedShape(Shape p) {
		// TODO Auto-generated method stub
		return s.createStrokedShape(p);
	}

}
