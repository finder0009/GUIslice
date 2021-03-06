/**
 *
 * The MIT License
 *
 * Copyright 2018, 2019 Paul Conti
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */
package builder.models;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;

import builder.common.ColorFactory;
import builder.common.EnumFactory;
import builder.events.MsgBoard;
import builder.events.MsgEvent;

/**
 * The Class ProgressBarModel implements the model for the Progress Bar widget.
 * 
 * @author Paul Conti
 * 
 */
public class ProgressBarModel extends WidgetModel { 
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1L;
  
  /** The Constant for gslc_tsElemRef* m_pElementRef name */
  public static final String ELEMENTREF_NAME = "m_pElemProgress";
  
  /** The Constant PROP_ELEMENTREF. */
  static private final int PROP_ELEMENTREF        = 6;
  
  /** The Constant PROP_VERTICAL. */
  static private final int PROP_VERTICAL          =7;
  
  /** The Constant PROP_RAMP. */
  static private final int PROP_RAMP              =8;
  
  /** The Constant PROP_MIN. */
  static private final int PROP_MIN               =9;
  
  /** The Constant PROP_MAX. */
  static private final int PROP_MAX               =10;
  
  /** The Constant PROP_VALUE. */
  static private final int PROP_VALUE             =11;
  
  /** The Constant PROP_GAUGE_COLOR. */
  static private final int PROP_GAUGE_COLOR       =12;
  
  /** The Constant PROP_DEFAULT_COLORS. */
  static private final int PROP_DEFAULT_COLORS    =13;
  
  /** The Constant PROP_FRAME_COLOR. */
  static private final int PROP_FRAME_COLOR       =14;
  
  /** The Constant PROP_FILL_COLOR. */
  static private final int PROP_FILL_COLOR        =15;
  
  /** The Constant PROP_SELECTED_COLOR. */
  static private final int PROP_SELECTED_COLOR    =16;
    
  static private final int DEF_WIDTH = 50;
  static private final int DEF_HEIGHT= 10;
  
  /**
   * Instantiates a new progress bar model.
   */
  public ProgressBarModel() {
    cf = ColorFactory.getInstance();
    initProperties();
  }
  
  /**
   * Initializes the properties.
   */
  protected void initProperties()
  {
    widgetType = EnumFactory.PROGRESSBAR;
    data = new Object[17][5];
    
    initCommonProps(DEF_WIDTH, DEF_HEIGHT);
    
    initProp(PROP_ELEMENTREF, String.class, "TXT-206", Boolean.FALSE,"ElementRef","");
    initProp(PROP_VERTICAL, Boolean.class, "BAR-100", Boolean.FALSE,"Vertical?",Boolean.FALSE);
    initProp(PROP_RAMP, Boolean.class, "BAR-101", Boolean.FALSE,"Ramp Style?",Boolean.FALSE);

    initProp(PROP_MIN, Integer.class, "BAR-102", Boolean.FALSE,"Minimum Value",Integer.valueOf(0));
    initProp(PROP_MAX, Integer.class, "BAR-103", Boolean.FALSE,"Maximum Value",Integer.valueOf(100));
    initProp(PROP_VALUE, Integer.class, "BAR-104", Boolean.FALSE,"Starting Value",Integer.valueOf(0));

    initProp(PROP_GAUGE_COLOR, Color.class, "COL_308", Boolean.FALSE,"Gauge Indicator Color",Color.GREEN);
    initProp(PROP_DEFAULT_COLORS, Boolean.class, "COL-300", Boolean.FALSE,"Use Default Colors?",Boolean.TRUE);
    initProp(PROP_FRAME_COLOR, Color.class, "COL-302", Boolean.TRUE,"Frame Color",cf.getDefFrameCol());
    initProp(PROP_FILL_COLOR, Color.class, "COL-303", Boolean.TRUE,"Fill Color",cf.getDefFillCol());
    initProp(PROP_SELECTED_COLOR, Color.class, "COL-304", Boolean.TRUE,"Selected Color",cf.getDefGlowCol());
  }
  
  /**
   * Gets the element ref.
   *
   * @return the element ref
   */
  public String getElementRef() {
    return (String) data[PROP_ELEMENTREF][PROP_VAL_VALUE];
  }
  
  /**
   * Sets the element ref.
   *
   * @param s
   *          the new element ref
   */
  public void setElementRef(String s) { 
    shortcutValue(s, PROP_ELEMENTREF);
  }
  
  /**
   * Gets the indicator color.
   *
   * @return the indicator color
   */
  public Color getIndicatorColor() {
    return (((Color) data[PROP_GAUGE_COLOR][PROP_VAL_VALUE]));
  }

  /**
   * Checks if is vertical.
   *
   * @return true, if is vertical
   */
  public boolean isVertical() {
    return ((Boolean) data[PROP_VERTICAL][PROP_VAL_VALUE]).booleanValue();
  }

  /**
   * Checks if is ramp style.
   *
   * @return true, if is ramp style
   */
  public boolean isRampStyle() {
    return ((Boolean) data[PROP_RAMP][PROP_VAL_VALUE]).booleanValue();
  }

  /**
   * Gets the min.
   *
   * @return the min
   */
  public int getMin() {
    return (((Integer) (data[PROP_MIN][PROP_VAL_VALUE])).intValue());
  }
  
  /**
   * Gets the max.
   *
   * @return the max
   */
  public int getMax() {
    return (((Integer) (data[PROP_MAX][PROP_VAL_VALUE])).intValue());
  }
  
  /**
   * Gets the value.
   *
   * @return the value
   */
  public int getValue() {
    return (((Integer) (data[PROP_VALUE][PROP_VAL_VALUE])).intValue());
  }

  /**
   * Use default colors.
   *
   * @return <code>true</code>, if successful
   */
  public boolean useDefaultColors() {
    return ((Boolean) data[PROP_DEFAULT_COLORS][PROP_VAL_VALUE]).booleanValue();
  }
  
  /**
   * Gets the fill color.
   *
   * @return the fill color
   */
  public Color getFillColor() {
    return (((Color) data[PROP_FILL_COLOR][PROP_VAL_VALUE]));
  }

  /**
   * Gets the frame color.
   *
   * @return the frame color
   */
  public Color getFrameColor() {
    return (((Color) data[PROP_FRAME_COLOR][PROP_VAL_VALUE]));
  }

 /**
  * Gets the selected color.
  *
  * @return the selected color
  */
 public Color getSelectedColor() {
   return (((Color) data[PROP_SELECTED_COLOR][PROP_VAL_VALUE]));
 }

  /**
   * changeValueAt
   *
   * @see builder.models.WidgetModel#changeValueAt(java.lang.Object, int)
   */
  @Override
  public void changeValueAt(Object value, int row) {
    // The test for Integer supports copy and paste from clipboard.
    // Otherwise we get a can't cast class String to Integer fault
    if ( (getClassAt(row) == Integer.class) && (value instanceof String)) {
        data[row][PROP_VAL_VALUE] = Integer.valueOf(Integer.parseInt((String)value));
    } else {
      data[row][PROP_VAL_VALUE] = value;
    }
    fireTableCellUpdated(row, COLUMN_VALUE);
    if (row == PROP_VERTICAL) {
      // swap height and width
      int tmp = getWidth();
      setWidth(getHeight());
      setHeight(tmp);
      fireTableCellUpdated(PROP_WIDTH, COLUMN_VALUE);
      fireTableCellUpdated(PROP_HEIGHT, COLUMN_VALUE);
    }
    if (row == PROP_DEFAULT_COLORS) {
      // check for switching back and forth
      if (useDefaultColors()) {
        data[PROP_FRAME_COLOR][PROP_VAL_VALUE]=cf.getDefFrameCol(); 
        data[PROP_FILL_COLOR][PROP_VAL_VALUE]=cf.getDefFillCol();
        data[PROP_SELECTED_COLOR][PROP_VAL_VALUE]=cf.getDefGlowCol(); 
        data[PROP_FRAME_COLOR][PROP_VAL_READONLY]=Boolean.TRUE; 
        data[PROP_FILL_COLOR][PROP_VAL_READONLY]=Boolean.TRUE;
        data[PROP_SELECTED_COLOR][PROP_VAL_READONLY]=Boolean.TRUE; 
      } else {
        data[PROP_FRAME_COLOR][PROP_VAL_READONLY]=Boolean.FALSE; 
        data[PROP_FILL_COLOR][PROP_VAL_READONLY]=Boolean.FALSE;
        data[PROP_SELECTED_COLOR][PROP_VAL_READONLY]=Boolean.FALSE; 
      }
      fireTableCellUpdated(PROP_FRAME_COLOR, COLUMN_VALUE);
      fireTableCellUpdated(PROP_FILL_COLOR, COLUMN_VALUE);
      fireTableCellUpdated(PROP_SELECTED_COLOR, COLUMN_VALUE);
    }     
    if (bSendEvents) {
      event = new MsgEvent();
      event.code = MsgEvent.WIDGET_REPAINT;
      event.message = getKey();
      MsgBoard.getInstance().publish(event);
    }
  }

  /**
   * readModel() will deserialize our model's data from a string object for backup
   * and recovery.
   *
   * @param in
   *          the in stream
   * @param widgetType
   *          the widget type
   * @throws IOException
   *           Signals that an I/O exception has occurred.
   * @throws ClassNotFoundException
   *           the class not found exception
   * @see builder.models.WidgetModel#readModel(java.io.ObjectInputStream, java.lang.String)
   */
  @Override
  public void readModel(ObjectInputStream in, String widgetType) 
      throws IOException, ClassNotFoundException {
//  System.out.println("WM readModel() " + getKey());
    if (widgetType != null)
      this.widgetType = widgetType;
    bSendEvents = in.readBoolean();
//  System.out.println("bSendEvents: " + bSendEvents);
    int rows = in.readInt();
    String metaID = null;
    Object objectData = null;
    int row;
//  System.out.println("WM rows: " + rows);
    boolean bNeedFix = false;
    for (int i=0; i<rows; i++) {
      metaID = (String)in.readObject();
      objectData = in.readObject();
      // work-around fix for bug in beta release where metaID's BAR-100, BAR-101 were duplicated
      // and BAR-102 was miss-assigned
      if (metaID.equals("BAR-102") && bNeedFix) {
        metaID = "BAR-104";
        bNeedFix = false;
      }
      if (metaID.equals("BAR-100") && objectData instanceof Integer) {
        metaID = "BAR-102";
        bNeedFix = true;
      }
      if (metaID.equals("BAR-101") && objectData instanceof Integer) {
        metaID = "BAR-103";
      }
      row = super.mapMetaIDtoProperty(metaID);
      if (row >= 0) {
        data[row][PROP_VAL_VALUE] = objectData;
/*
   System.out.println(data[row][PROP_VAL_NAME].toString() + ": " + data[row][PROP_VAL_VALUE].toString()
         + " mapped to row " + row);
*/   
      }
    }
    if (useDefaultColors()) {
      data[PROP_FRAME_COLOR][PROP_VAL_READONLY]=Boolean.TRUE; 
      data[PROP_FILL_COLOR][PROP_VAL_READONLY]=Boolean.TRUE;
      data[PROP_SELECTED_COLOR][PROP_VAL_READONLY]=Boolean.TRUE; 
    } else {
      data[PROP_FRAME_COLOR][PROP_VAL_READONLY]=Boolean.FALSE; 
      data[PROP_FILL_COLOR][PROP_VAL_READONLY]=Boolean.FALSE;
      data[PROP_SELECTED_COLOR][PROP_VAL_READONLY]=Boolean.FALSE; 
    }
    // upgrade to beta release where previously ElementRef was empty
    if (getElementRef().equals("")) {
      int n = 0;
      String strKey = "";
      String strCount = ""; 
      String ref = ""; 
      ref = ELEMENTREF_NAME;
      strKey = getKey();
      n = strKey.indexOf("$");
      strCount = strKey.substring(n+1, strKey.length());
      ref = ref + strCount;
      setElementRef(ref);
    }
  }

}
