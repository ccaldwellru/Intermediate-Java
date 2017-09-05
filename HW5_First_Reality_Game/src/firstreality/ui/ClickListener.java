package firstreality.ui;

/**
 * The listener interface for receiving click events.
 * The class that is interested in processing a click
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addClickListener<code> method. When
 * the click event occurs, that object's appropriate
 * method is invoked.
 *
 * @see ClickEvent
 */
public interface ClickListener {

	/**
	 * On click.
	 */
	public void onClick();

}
