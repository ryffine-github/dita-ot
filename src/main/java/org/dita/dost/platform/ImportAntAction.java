/*
 * This file is part of the DITA Open Toolkit project.
 *
 * Copyright 2008 IBM Corporation
 *
 * See the accompanying LICENSE file for applicable license.

 */
package org.dita.dost.platform;

//import org.dita.dost.util.FileUtils;
import org.dita.dost.util.XMLUtils;
import org.dita.dost.util.XMLUtils.AttributesBuilder;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import static javax.xml.XMLConstants.NULL_NS_URI;

/**
 * Ant import task.
 *
 * @since 3.0
 */
final class ImportAntAction extends ImportAction {

    /**
     * Generate Ant import task.
     */
    @Override
    public void getResult(final ContentHandler buf) throws SAXException {
//        final String templateFilePath = paramTable.get(FileGenerator.PARAM_TEMPLATE);
        for (final String value: valueSet) {
//            final String path = FileUtils.getRelativeUnixPath(templateFilePath, value);
//            buf.startElement(NULL_NS_URI, "import", "import", new AttributesBuilder()
//                .add("file", path)
//                .build());
//            final String path = FileUtils.getRelativeUnixPath(templateFilePath, value);
            final String[] tokens = value.split("[/\\\\]", 2);
            buf.startElement(NULL_NS_URI, "import", "import", XMLUtils.EMPTY_ATTRIBUTES);
            buf.startElement(NULL_NS_URI, "fileset", "fileset", new AttributesBuilder()
                    .add("dir", tokens[0])
                    .add("includes", tokens[1])
                    .build());
            buf.endElement(NULL_NS_URI, "fileset", "fileset");
            buf.endElement(NULL_NS_URI, "import", "import");
        }
    }

}
